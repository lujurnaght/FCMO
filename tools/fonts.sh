#!/bin/sh
# Archivo (display) and Instrument Sans (text) from google/fonts, SIL Open Font License.
# File names are looked up rather than guessed, since variable-font names carry their axes.
set -e
mkdir -p app/src/main/res/font
fetch() {
  dir=$1; out=$2
  name=$(curl -fsSL ${GH_TOKEN:+-H "Authorization: Bearer $GH_TOKEN"} "https://api.github.com/repos/google/fonts/contents/ofl/$dir" \
    | python3 -c "import json,sys; n=sorted(f['name'] for f in json.load(sys.stdin) if f['name'].endswith('.ttf') and 'Italic' not in f['name']); print(n[0])")
  enc=$(python3 -c "import urllib.parse,sys; print(urllib.parse.quote(sys.argv[1]))" "$name")
  curl -fsSL "https://raw.githubusercontent.com/google/fonts/main/ofl/$dir/$enc" -o "app/src/main/res/font/$out"
  echo "$dir -> $name"
}
fetch archivo archivo.ttf
fetch instrumentsans instrument.ttf
ls -la app/src/main/res/font
