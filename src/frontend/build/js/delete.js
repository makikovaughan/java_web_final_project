//Get the delete ID information
const myForm = document.getElementById("my-form");
let idNumber;

//Update the travel review data.
const deleteData = async () => {
  try {
    //Send a delete request
    const response = await fetch(`http://localhost:8080/travels/${idNumber}`, {
      method: "DELETE",
    });

    //Returned data
    const data = await response.json();

    //Reload a page to reflect the new input
    document.location.reload();
    return data;
    throw new Error("Request failed");
  } catch (e) {
    console.log(e);
  }
};

const submitTravel = (event) => {
  event.preventDefault();
  // Get the input
  idNumber = myForm.elements[0].value;
  deleteData();
};

myForm.onsubmit = submitTravel;
