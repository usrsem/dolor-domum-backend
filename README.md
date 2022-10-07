# Dolor Domum backend service

## Features
* Handle contact us requests

## Setup
Fill app application.yml as shown:
```yaml
telegram:
  botToken: yourBotToken
  toChatIds:
    - idForGettingMessageFromRequest
```

## How to run
```shell
./gradlew bootRun
```