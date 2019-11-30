(function() {
    let table = document.querySelector("#services tbody");
    
    function mount(item){
        let targetMarket = "",
        stack = "";
        item.stack.map(function(item){
            stack += '<li>' + item + '</li>';
        });
        item.targetMarket.map(function(item){
            targetMarket += '<li>' + item + '</li>';
        });

        let row = `<td>${item.productName}</td>
                   <td>${item.description}</td>
                   <td><ul>${targetMarket}</ul></td>
                   <td><ul>${stack}</ul></td>
                  `,
        tr = document.createElement('tr');
        tr.innerHTML = row;
        table.appendChild(tr);   
   }
   
    var ajax = new XMLHttpRequest();
    ajax.open("GET", "/api/products", true);
    ajax.send();
    ajax.onreadystatechange = function() {
    if (ajax.readyState == 4 && ajax.status == 200) {
            var data = ajax.responseText;
            gubee = JSON.parse(data);
            while (table.lastChild) {
                table.removeChild(table.lastChild);
            }
            gubee.forEach(function(item){
                mount(item)
            });
    }
   };
   
   let filterMarket, filterStack;
   
   filterMarket = document.querySelector("#filterMarket");
   filterStack = document.querySelector("#filterStack");
   
   if(filterMarket  !== null){
    filterMarket.addEventListener("change", function(e){
        ajax.open("GET", `/api/products/search?stack=${filterStack.value}&market=${filterMarket.value}`);
        ajax.send();
    });
   }
   if(filterStack  !== null){
    filterStack.addEventListener("change", function(e){
       ajax.open("GET", `/api/products/search?stack=${filterStack.value}&market=${filterMarket.value}`);
       ajax.send();
    });
   }
   
   
})();


