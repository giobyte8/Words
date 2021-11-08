#
# Creates an openjdk image with the words jar file inside it
#  - jar will be started along with container.
#  - Spring application.yml is read from container home/words/application.yml
#    so you can pass it as a volume (Check below examples)
#
#
# NOTE
# In order to copy jar file, below path must
# be valid relatively to the build context.
#
#  - build/libs/words-${wordsVersion}.jar
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
# Use something like:
# > docker run -d                                    \
# >   -p 7000:80                                     \
# >   -v application.yml:/home/words/application.yml \
# >   --name words                                   \
# >   words:1.0.0
#

FROM openjdk:17
ARG wordsVersion=0.0.1-SNAPSHOT

COPY build/libs/words-${wordsVersion}.jar /home/words/words.jar

WORKDIR /home/words/
ENTRYPOINT [                                                             \
    "java",                                                              \
    "-jar",                                                              \
    "words.jar",                                                         \
    "--spring.config.location=file:///home/words/application.yml"        \
]
