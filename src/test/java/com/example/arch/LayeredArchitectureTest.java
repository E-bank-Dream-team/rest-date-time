package com.example.arch;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTag;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import static com.tngtech.archunit.library.freeze.FreezingArchRule.freeze;

@ArchTag("arch")
@AnalyzeClasses(packages = "com.example", importOptions = { ImportOption.DoNotIncludeTests.class, ImportOption.DoNotIncludeJars.class, ImportOption.DoNotIncludeArchives.class })
public class LayeredArchitectureTest {


    @ArchTest
    static final ArchRule layer_dependencies_are_respected = freeze(layeredArchitecture()
            .layer("Controllers")
            .definedBy("com.example.controllers..")
            .layer("Services")
            .definedBy("com.example.services..")
            .layer("Repositories")
            .definedBy("com.example.repositories..")
            .whereLayer("Controllers")
            .mayNotBeAccessedByAnyLayer()
            .whereLayer("Services")
            .mayOnlyBeAccessedByLayers("Controllers")
            .whereLayer("Repositories")
            .mayOnlyBeAccessedByLayers("Services"));

}
