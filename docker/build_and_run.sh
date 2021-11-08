#!/usr/bin/env bash
# Builds and run specified app version through below steps
#  1. Compiles java application
#  2. Builds docker image for app version specified in build.gradle
#  3. Starts docker container for built image
#

# ref: https://stackoverflow.com/a/4774063/3211029
HERE="$( cd -- "$(dirname "$0")" >/dev/null 2>&1 ; pwd -P )"

cd "${HERE}/.." || return
APP_ROOT=$(pwd)
GRADLE_BUILD_FILE="${APP_ROOT}/build.gradle"
cd "${HERE}" || return


## Build app
bash "${HERE}/build_app.sh"


## Get app version from 'build.gradle' file
VERSION_LINE=$(grep "version =" "${GRADLE_BUILD_FILE}")
IFS='= ' read -r -a VERSION_SPLIT <<< "$VERSION_LINE"
if [ ${#VERSION_SPLIT[@]} -ne 2 ]; then
  echo "Version number could not be read from ${GRADLE_BUILD_FILE}"
  exit 1
fi

VERSION="${VERSION_SPLIT[1]}"
VERSION=${VERSION#"'"}
VERSION=${VERSION%"'"}


## Build docker image and start container
echo
echo "Deploying version ${VERSION} through docker"
WORDS_VERSION=$VERSION docker-compose up -d
