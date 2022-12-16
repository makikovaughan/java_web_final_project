// Get data to display on the page.
const getData = async () => {
  try {
    //Getting <p>tag(id = hello)
    const divTag = document.getElementById("travel");

    //Get the data
    const response = await fetch("http://localhost:8080/travels");

    if (response.ok) {
      //Get the response
      const jsonResponse = await response.json();

      //Create a tabel dynamically
      let tableContent = `<table class="table table-striped table-hover bg-info text-dark bg-opacity-25 rounded-4">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Country</th>
            <th scope="col">Review Rate</th>
            <th scope="col">Comment</th>
          </tr>
        </thead>
        <tbody>`;

      //For loop to display all results.
      for (let i = 0; i < jsonResponse.length; i++) {
        tableContent += `
            <tr>
            <th scope="row">${jsonResponse[i].id}</th>
            <td>${jsonResponse[i].country}</td>
            <td>${jsonResponse[i].review}</td>
            <td>${jsonResponse[i].comment}</td>
          </tr>`;
      }

      //Closing tag for table
      tableContent += ` </tbody>
        </table>`;

      //Adding the table in the div container
      divTag.innerHTML = tableContent;
      return jsonResponse;
    }
    throw new Error("Request failed");
  } catch (error) {
    console.log(error);
  }
};

//Call getData to launch
getData();
