# ss-wise-api-integration

## Project Description

This is a slow self-study Java project focused on integrating with the Wise API.

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

Create or update src/main/resources/config.properties with your own values:

URL=https://api.wise-sandbox.com
READ_TOKEN=your_personal_read_token
FULL_TOKEN=your_personal_full_token

Important:

- Never commit real API keys to source control.
- Keep config.properties ignored in git.

## Run

Build:

mvn compile

Run the main class:

java -cp target/classes main.java.Main

On success, the app prints status 200 and the JSON response from the Wise profiles endpoint.
