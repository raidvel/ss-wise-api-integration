# ss-wise-api-integration

## Project Description

This is a slow self-study Java project focused on integrating with the Wise API.

Current implementation:

- Calls Wise Sandbox Profiles endpoint: /v2/profiles
- Uses Java HttpClient for REST requests
- Uses Jackson for JSON formatting
- Loads base URL from config.properties
- Loads Wise API token from environment variables based on APP_ENV

The goal of the project is to practice:

- Writing code for the whole project - no AI written code.
- Calling external REST APIs from Java using HttpClient
- Managing configuration and API credentials safely
- Working with Maven project structure and dependencies
- Inspecting and formatting JSON responses for development

## Prerequisites

To run this project, you need:

- Java 17+
- Maven
- A Wise Sandbox account
- Personal Wise API keys generated from your Sandbox account

Without a valid Sandbox account and personal API key, requests will fail with authentication errors.

## Configuration

Set configuration in src/main/resources/config.properties:

URL=https://api.wise-sandbox.com

Set secrets in environment variables (not in files):

- APP_ENV=TEST or PROD
- WISE_TEST_READ_TOKEN=your_test_read_token
- WISE_PROD_READ_TOKEN=your_prod_read_token

Notes:

- APP_ENV defaults to TEST when missing.
- Current code path uses READ token only.
- FULL token variables can be added later when write operations are implemented.

Important:

- Never commit real API keys to source control.
- Keep config.properties ignored in git.
- Rotate tokens immediately if they were exposed.

## Environment Setup (PowerShell)

For current terminal session:

$env:APP_ENV="TEST"
$env:WISE_TEST_READ_TOKEN="your_test_read_token"

Persist for future sessions:

setx APP_ENV "TEST"
setx WISE_TEST_READ_TOKEN "your_test_read_token"

After using setx, open a new terminal (or restart VS Code) before running.

## Run

Build:

mvn compile

Run the main class:

java -cp target/classes main.java.Main

On success, the app prints the JSON response from the Wise profiles endpoint.

If startup fails with missing environment variable, verify APP_ENV and the matching Wise token variable are set in the same terminal used to run Java.
