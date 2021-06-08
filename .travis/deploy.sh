#!/bin/sh

mkdir target/github-pages
git clone --single-branch --branch gh-pages https://romangitlab:$GITHUB_TOKEN@github.com/romangitlab/movie-db.git target/github-pages
cp -R target/github-pages/history target/allure-results/
mvn allure:report
cp -R target/site/allure-maven-plugin/* target/github-pages/
cd target/github-pages
git config user.name "Travis CI"
git config user.email "deploy@travis-ci.org"
git add *
git commit -m "Auto deploy from Travis CI build $TRAVIS_BUILD_NUMBER"
git push -u origin gh-pages