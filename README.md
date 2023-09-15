# LAA Cazoo Exercise

Serenity BDD is a library that makes it easier to write high quality automated acceptance tests, with powerful reporting and living documentation features. It has strong support for both web testing with Selenium, and API testing using RestAssured.

Serenity strongly encourages good test automation design, and supports several design patterns, including classic Page Objects, the newer Lean Page Objects/ Action Classes approach, and the more sophisticated and flexible Screenplay pattern.

Serenity 2.2.13 introduced integration with WebdriverManager to download webdriver binaries.

We can add more input files to resources folder at `resources/files` and we can add the file name to Examples in Gherkin feature file.

At the moment this tool supports following regular expressions to match the car registrations, we can add more expressions as we learn more about the car registration patterns.

```aidl
([A-Z]{2}[0-9]{2}\s*[A-Z]{3})
([A-Z][0-9]{1,3}\s*[A-Z]{3})
([A-Z]{3}[0-9]{1,3}[A-Z])
([0-9]{1,4}[A-Z]{1,2})
([0-9]{1,3}[A-Z]{1,3})
([A-Z]{1,2}[0-9]{1,4})
([A-Z]{1,3}[0-9]{1,3})
([A-Z]{1,3}[0-9]{1,4})
([0-9]{3}[DX]{1}[0-9]{3})
```
## Executing the tests
To run the sample project, we can either just run the `CucumberTestSuite` test runner class, or run either `gradle test` from the command line.

```json
$ gradle clean test aggregate
```

By default, the tests will run using Chrome. We have a possibility to add capabilities for other browsers, then we can run them with Firefox by overriding the `driver` system property, e.g.
```json
$ gradle clean test -Pdriver=firefox
```

## Generating the reports

The test results will be recorded in the `target/site/serenity` directory.

The sample report will be shown as per the image below, quite comprehensive, it's good for debugging purposes
![img_1.png](img_1.png)

![img.png](img.png)
`
Serenity uses WebDriverManager to download the WebDriver binaries automatically before the tests are executed.

### Environment-specific configurations
We can also configure environment-specific properties and options like below which I haven't implemented yet, so that the tests can be run in different environments. Here, we configure three environments, __dev__, _staging_ and _prod_, with different starting URLs for each:
```json
environments {
  default {
    webdriver.base.url = "https://cazoo.com"
  }
  dev {
    webdriver.base.url = "https://cazoo.com/dev"
  }
  staging {
    webdriver.base.url = "https://cazoo.com/staging"
  }
  prod {
    webdriver.base.url = "https://cazoo.com/prod"
  }
}
```

You use the `environment` system property to determine which environment to run against. For example to run the tests in the staging environment, you could run:
```json
$ gradle clean verify -Denvironment=staging
```
