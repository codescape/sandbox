grails.servlet.version = "2.5"

grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {

    inherits("global")
    log "warn"

    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenLocal()        
        mavenCentral()
    }

    def gebVersion = "0.6.0"
    def seleniumVersion = "2.0rc3"

    dependencies {
        test("org.seleniumhq.selenium:selenium-htmlunit-driver:$seleniumVersion") {
            exclude "xml-apis"
        }
        test("org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion")
        test("org.seleniumhq.selenium:selenium-firefox-driver:$seleniumVersion")    

        test "org.codehaus.geb:geb-spock:$gebVersion"        
    }

    plugins {
        compile ":hibernate:$grailsVersion"
        compile ":jquery:1.6.1.1"
        compile ":resources:1.0.2"

        build ":tomcat:$grailsVersion"

        test ":geb:$gebVersion"
        test ":spock:0.6-SNAPSHOT"
    }

}
