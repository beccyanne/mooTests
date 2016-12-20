# mooTests
<strong>Pre-requisites</strong>
<ul><li>To run the tests you need google chrome installed</li>
<li>The tests automatically download the appropriate drivers for the OS you are using - tested on Mac only but should also work on Windows.</li>
<strong>To execute the tests</strong>
After cloning the project navigate to the folder where it has the pom.xml file
then run:
mvn clean integration-test -DsuiteXmlFile=smoke-tests.xml

<strong>Automated checks:</strong>
1 - Search for invalid product
2 - Search for valid product
3 - Invalid login
4 - Cost Calculator Test
