function compile() {
  filename="$1"
  if [ -z "$filename" ]; then
    echo "Kotlin program name expected"
    return 1
  fi

  extension="${filename##*.}"
  if [ "$extension" != "kt" ]; then
    echo ".kt file expected"
    return 1
  fi

  program_name=$(basename "$1" .kt)
  kotlinc $1 -include-runtime -d ${program_name}.jar
  return "$?"
}

function run() {
  compile "$@"
  compile_code=$?
  program_name=$(basename "$1" .kt)
  if [ "$compile_code" -eq 0 ]; then
    java -jar ${program_name}.jar
  else
    echo "not compiled exit with status: ${?}"
  fi
}