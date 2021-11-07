#
# Creates an openjdk:17 image with the words jar and spring config
# files inside it.
# The jar will be started along with container.
#
#
# NOTE
# In order to copy jar and yml files, below paths must
# be valid relatively to the build context.
#
#  - build/libs/words-${wordsVersion}.jar
#  - docker/application.yml
#
# The 'wordsVersion' is a build variable, check below examples
#
#
# BUILDING IMAGE
# Building image from dockerfile directory:
# > docker build --build-arg wordsVersion=1.0.0 -t words:1.0.0 -f words.dockerfile ../
#
# Building image from repo root:
# > docker build --build-arg wordsVersion=1.0.0 -t words:1.0.0 -f docker/words.dockerfile .
#
#
# RUNNING IMAGE
# Running through docker run
# > docker run -d -p 7000:80 --name words words:1.0.0
#
# Running through docker compose
# > TODO
# >
#

FROM openjdk:17
ARG wordsVersion=0.0.1-SNAPSHOT

COPY build/libs/words-${wordsVersion}.jar /home/words/words.jar
COPY docker/application.yml /home/words/application.yml

WORKDIR /home/words/
ENTRYPOINT [                                                             \
    "java",                                                              \
    "-jar",                                                              \
    "words.jar",                                                         \
    "--spring.config.location=file:///home/words/application.yml"        \
]
