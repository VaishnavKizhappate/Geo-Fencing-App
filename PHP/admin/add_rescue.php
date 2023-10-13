<?php

	include('config.php');

$district = $_POST['district'];
$area = $_POST['area'];
$name = $_POST['name'];
$contact = $_POST['contact'];

$query="INSERT INTO rescue_team (district,area,name,contact) VALUES('$district','$area','$name','$contact')";
$r=mysqli_query($conn, $query) or die("error in deletion".mysqli_error());

if($r)
{
    ?>
    <script language="javascript">alert('Added Successfully');
    window.location.replace('home.html');
    </script>
    <?php
}

else
{
    ?>
    <script language="javascript">alert('Failed To Add');</script>
    <?php
}


?>