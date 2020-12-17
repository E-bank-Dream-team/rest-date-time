package com.example.arch;

import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideInAPackage;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTag;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import org.springframework.web.bind.annotation.RestController;

@ArchTag("arch")
@AnalyzeClasses(packages = "com.example", importOptions = { ImportOption.DoNotIncludeTests.class, ImportOption.DoNotIncludeJars.class, ImportOption.DoNotIncludeArchives.class })
public class ControllerRulesTest {

    @ArchTest
    static final ArchRule controllers_should_implement_openapi_interface = classes().that()
            .resideInAPackage("..controllers..")
            .and()
            .areAnnotatedWith(RestController.class)
            .should()
            .implement(resideInAPackage("..autogenerated.api.."))
            .because("Controller has to implement interface autogenerated from OpenAPI ");

}
