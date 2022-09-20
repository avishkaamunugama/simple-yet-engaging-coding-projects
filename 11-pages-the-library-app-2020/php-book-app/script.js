function switchView(div_id) {
  document.getElementById("sect1").innerHTML = document.getElementById(
    div_id
  ).innerHTML;

  console.log(div_id);

  if (div_id === "sect1") {
    document.getElementById("sect1").innerHTML = `
    <h2>Add new Book/AudioBook</h2>
    <form action="addDevice.php" method="POST" id="form1">
      <label for="catalogName">Title</label>
      <input type="text" name="catalogName" placeholder="Book / AudioBook Title " required><br>

      <label for="descrip">Author</label>
      <input type="text" name="descrip" placeholder="Authored by"><br>

      <label for="availability">Category</label>
      <input type="text" name="availability" placeholder="Category / Genre"><br>

      <button type="submit" id="dSubmit">Submit</button>

    </form>

    <button id="moreBtn" onclick="switchView('chooseDevice')">Add more details</button>

  </div>


  <div id="chooseDevice" style="display: none;">

    <h2 id="cdH2">
      Choose type to proceed
    </h2>
    <div id="chooseBtns">
      <button id="visBtn" onclick="switchView('sect2')">Audio Book</button>
      <button id="hearBtn" onclick="switchView('sect3')">Hard-copy Book</button>
    </div>
    <button type="button" onclick="switchView('sect1')" id="backBtn1" class="backBtn">Go Back</button>

  </div>


        `;
  }
}

