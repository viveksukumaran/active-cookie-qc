# active-cookie-qc
most active cookie

## How to build
1. Clone the repo - git clone https://github.com/viveksukumaran/active-cookie-qc.git
2. cd active-cookie-qc
3. Run gradle build
    #### On WINDOWS
    .\gradlew.bat clean build
    #### On *nix
    ./gradlew clean build

## How to run
java -jar .\build\libs\active-cookie-qc-1.0.0.jar analyze -f ./logs/sample.csv -d 2020-10-12
