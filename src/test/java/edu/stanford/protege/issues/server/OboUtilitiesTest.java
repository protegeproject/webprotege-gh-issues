package edu.stanford.protege.issues.server;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.vocab.OWLRDFVocabulary;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 21 Aug 2017
 */
public class OboUtilitiesTest {

    @Test
    public void shouldRecogniseAsOboId() {
        assertThat(OboUtilities.isOboId("GO:0001234"), is(true));
    }

    @Test
    public void shouldRecogniseWithUnderscoreAsOboId() {
        assertThat(OboUtilities.isOboId("OTHER_THING:0001234"), is(true));
    }

    /**
     * Test for https://github.com/protegeproject/protege/issues/765
     */
    @Test
    public void shouldProcessLongName() {
        assertThat(OboUtilities.isOboId("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"), is(false));
    }

    @Test
    public void shouldNotRecogniseAsOboId() {
        assertThat(OboUtilities.isOboId("owl:Thing"), is(false));
    }

    @Test
    public void shouldRecogniseOboLibraryIri() {
        assertThat(OboUtilities.isOboIri(IRI.create("http://purl.obolibrary.org/obo/GO_0001234")), is(true));
    }

    @Test
    public void shouldRecogniseOboIri() {
        assertThat(OboUtilities.isOboIri(IRI.create("http://other.place.org/obo/MY_0001234")), is(true));
    }

    @Test
    public void shouldNotRecogniseOboIri() {
        assertThat(OboUtilities.isOboIri(OWLRDFVocabulary.RDFS_LABEL.getIRI()), is(false));
    }

    @Test
    public void shouldParseOboId() {
        IRI iri = OboUtilities.getOboLibraryIriFromOboId("GO:0001234");
        assertThat(iri.toString(), is("http://purl.obolibrary.org/obo/GO_0001234"));
    }

    @Test
    public void shouldParseOboIdWithUnderscore() {
        IRI iri = OboUtilities.getOboLibraryIriFromOboId("OTHER_THING:0001234");
        assertThat(iri.toString(), is("http://purl.obolibrary.org/obo/OTHER_THING_0001234"));
    }

    @Test
    public void shouldThrowRuntimeException() {
        assertThrows(RuntimeException.class, () -> {
            OboUtilities.getOboLibraryIriFromOboId("owl:Thing");
        });
    }

    @Test
    public void shouldGetOboIdFromIri() {
        Optional<String> id = OboUtilities.getOboIdFromIri(IRI.create("http://purl.obolibrary.org/obo/GO_0001234"));
        assertThat(id, is(Optional.of("GO:0001234")));
    }

    @Test
    public void shouldGetOboIdFromIriWithUnderscoreLocalPart() {
        Optional<String> id = OboUtilities.getOboIdFromIri(IRI.create("http://purl.obolibrary.org/obo/OTHER_THING_0001234"));
        assertThat(id, is(Optional.of("OTHER_THING:0001234")));
    }

    @Test
    public void shouldNotGetOboIdFromInvalidOboIri() {
        Optional<String> id = OboUtilities.getOboIdFromIri(IRI.create("http://purl.obolibrary.org/obo/otherthing"));
        assertThat(id.isPresent(), is(false));
    }
}