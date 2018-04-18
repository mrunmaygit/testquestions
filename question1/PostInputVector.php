<?php

$data = 
[

				[190,11,12],
				[37,13,76],
				[10,11,12],
				[52,11,12],
				[232,11,12]
			];                                                                   
$data_string = json_encode($data);                                                                                   
$ch = curl_init('http://localhost/question1/ProcessVector.php');                                                                      
curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "GET");                                                                     
curl_setopt($ch, CURLOPT_POSTFIELDS, $data_string);                                                                  
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);                                                                      
curl_setopt($ch, CURLOPT_HTTPHEADER, array(                                                                          
    'Content-Type: application/json',                                                                                
    'Content-Length: ' . strlen($data_string))                                                                       
);                                                                                                                                                                                                                               
$result = curl_exec($ch);
print_r($result);