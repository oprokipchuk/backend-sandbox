call mvn clean install || exit /b %errorlevel%
call mvn verify -DskipUnitTests=true -P integration-tests || exit /b %errorlevel%
call mvn verify -DskipUnitTests=true -P component-tests || exit /b %errorlevel%
