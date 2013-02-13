package pieldeyeti.tutorialresthub;

import javax.inject.Inject;
import javax.inject.Named;

import org.resthub.common.util.PostInitialize;

import pieldeyeti.tutorialresthub.model.Sample;
import pieldeyeti.tutorialresthub.repository.SampleRepository;

@Named("sampleInitializer")
public class SampleInitializer {

    @Inject
    @Named("sampleRepository")
    private SampleRepository sampleRepository;

    @PostInitialize
    public void init() {
        sampleRepository.save(new Sample("testSample1"));
        sampleRepository.save(new Sample("testSample2"));
        sampleRepository.save(new Sample("testSample3"));
    }
}
