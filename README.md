# mooTests
<strong>Pre-requisites</strong>
<ul><li>To run the tests you need google chrome installed</li>
<li>The tests automatically download the appropriate drivers for the OS you are using - tested on Mac only but should also work on Windows.</li></ul><br/>
<strong>To execute the tests</strong>
<ul><li>After cloning the project navigate to the folder where it has the pom.xml file</li>
<li>then run: mvn clean integration-test -DsuiteXmlFile=smoke-tests.xml</li></ul>

<strong>Automated checks:</strong>
<ul><li>1 - Search for invalid product</li>
<li>2 - Search for valid product</li>
<li>3 - Invalid login</li>
<li>4 - Cost Calculator Test</li>
