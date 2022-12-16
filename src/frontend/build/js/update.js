//Get the update data information
const myForm = document.getElementById("my-form");
let cName;
let review;
let comment;
let idNumber;

//Update the travel review data.
const updateData = async () => {
  try {
    //Post data
    const requestOptions = {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        country: cName,
        review: review,
        comment: comment,
      }),
    };

    //Send a Post request
    const response = await fetch(
      `http://localhost:8080/travels/${idNumber}`,
      requestOptions
    );

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
  cName = myForm.elements[1].value;
  review = myForm.elements[2].value;
  comment = myForm.elements[3].value;
  updateData();
};

myForm.onsubmit = submitTravel;
