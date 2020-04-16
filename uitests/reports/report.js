$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src\\test\\java\\Features\\GoogleSearch.feature");
formatter.feature({
  "name": "Test to search in google",
  "description": "  I want to run a sample feature file.",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@smokeTest"
    }
  ]
});
formatter.scenario({
  "name": "Sample search",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smokeTest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "homepage is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "GoogleSearch.homepageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Search with the key word",
  "keyword": "When "
});
formatter.match({
  "location": "GoogleSearch.searchWithTheKeyWord()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Search suggestion are displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "GoogleSearch.searchSuggestionAreDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});