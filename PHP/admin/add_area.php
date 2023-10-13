<?php

	include('config.php');

$latitude = $_POST['latitude'];
$longitude = $_POST['longitude'];
$radius = $_POST['radius'];

$query="INSERT INTO restricted_areas (latitude,longitude,radius) VALUES('$latitude','$longitude','$radius')";
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