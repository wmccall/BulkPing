sh ./compileClasses.sh
rm BulkPing.jar
cd build/
jar cfm ../BulkPing.jar ../manifest.txt bulkping/*.class
cd ../
java -jar BulkPing.jar
