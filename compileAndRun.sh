rm -rf build
javac -d build/ ./src/bulkping/*
cd build/
java bulkping.BulkPing
