package com.example.arch;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import javax.persistence.Entity;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTag;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@ArchTag("arch")
@AnalyzeClasses(packages = "com.example", importOptions = { ImportOption.DoNotIncludeTests.class, ImportOption.DoNotIncludeJars.class, ImportOption.DoNotIncludeArchives.class })
public class DaoRulesTest {

    @ArchTest
    static final ArchRule entities_must_reside_in_a_model_package = classes().that()
            .areAnnotatedWith(Entity.class)
            .should()
            .resideInAPackage("..models..")
            .as("Entities should reside in a package '..models..'");

}
