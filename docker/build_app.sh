#!/usr/bin/env bash
#
# Compiles app into executable jar using a docker
# gradle container
#

# ref: https://stackoverflow.com/a/4774063/3211029
HERE="$( cd -- "$(dirname "$0")" >/dev/null 2>&1 ; pwd -P )"
cd "${HERE}/.." || return

APP_ROOT=$(pwd)
cd "${HERE}" || return

echo "Building app from ${APP_ROOT}"

docker run --rm -u gradle \
  -v "$APP_ROOT":/home/gradle/project \
  -w /home/gradle/project \
  gradle:7.2.0-jdk17-alpine gradle build
