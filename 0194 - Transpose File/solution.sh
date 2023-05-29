i=0; 
j=0;
declare -A transposedText

while IFS= read -r line; 
do
    j=0;
    for word in $line 
    do
        key="$j,$i"
        transposedText[$key]=$word
        j=$((j + 1))
    done
    i=$((i + 1))
done < "out.txt"

numberOfRows=$((${#transposedText[@]} / j))
numberOfColumns=$((${#transposedText[@]} / i))

for ((column=0; column<numberOfColumns; column++))
do
    lineString=""
    for ((row=0; row<numberOfRows; row++))
    do
        if [[ "$lineString" == "" ]]
        then
            lineString="${transposedText[$column,$row]}"
        else
            lineString="${lineString} ${transposedText[$column,$row]}"
        fi
    done
    echo $lineString
done
