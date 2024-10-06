## Sonarqube 6.7.7 (7.X and 8.x require higher JDK version)
### How to install sonarqube 6.7.0 on windows
1. Go to offical website : https://www.sonarqube.org/downloads/
2. Choose Community Edition
3. Get sonarqube-6.7.7.zip
4. Unzip this zip
5. Go to sonarqube-6.7.7\conf\sonar.properties
6. Add property sonar.search.port=0 due to port 9002 has already been used
7. Go to sonarqube-6.7.7\bin\windows-x86-64
8. Run StartSonar.bat
9. Check http://localhost:9000/


### How to install sonarqube 6.7.0 on Mac
1. Go to offical website : https://www.sonarqube.org/downloads/
2. Choose Community Edition
3. Get sonarqube-6.7.7.zip
4. Unzip this zip file
5. execute: XXX/sonarqube-6.7.7/bin/macosx-universal-64/sonar.sh console
6. Check http://localhost:9000/
