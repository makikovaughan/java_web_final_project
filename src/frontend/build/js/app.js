//Get the post data information
const myForm = document.getElementById("my-form");
let cName;
let review;
let comment;

//Post a new travel review data.
const submitData = async () => {
  try {
    //Post data
    const requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        country: cName,
        review: review,
        comment: comment,
      }),
    };

    //Send a Post request
    const response = await fetch(
      "http://localhost:8080/travels",
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
  cName = myForm.elements[0].value;
  review = myForm.elements[1].value;
  comment = myForm.elements[2].value;
  submitData();
};

myForm.onsubmit = submitTravel;
