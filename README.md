# pierceapi
RUN tests:
mvn clean test

# pierceapi
Install dependencies:
npm install

RUN tests:
npx playwright test

View test report:
npx playwright show-report
