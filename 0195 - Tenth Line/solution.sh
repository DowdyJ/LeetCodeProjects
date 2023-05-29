i=1; 
while IFS= read -r line; 
do
    
    if [[ $i == 10 ]]
    then
        echo $line
    fi
    i=$((i + 1))
done < "file.txt"