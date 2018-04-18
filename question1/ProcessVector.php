<?php

# Vector input [ You can change input as you want]
$input = json_decode(file_get_contents('php://input'));
$result;

# Iterate with vector
for ($i=0; $i < count($input)-1; $i++) { 
	for($j=$i+1; $j<= count($input); $j++){

		# Check if saturation and value matches
		if($input[$i][1]==$input[$j][1] && $input[$i][2]==$input[$j][2] ){

			# Check if addition of respective deggrees is 180
			if($input[$i][0]+180==$input[$j][0]){
				$result[] = $input[$i];
				$result[] = $input[$j];
			}
		}
	}
}

# If result not empty provide result in JSON Format
if(!empty($result)){
	echo json_encode($result);
}

# Else provide no result status
else{
	$result["messages"]="No records found !";
	echo json_encode($result);
}
