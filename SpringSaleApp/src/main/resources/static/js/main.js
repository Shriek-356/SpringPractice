/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


function deleteProduct(endpoint, id){
    
    
    if(confirm("Ban co chac chan muon xoa hay khong?") === true){
        fetch(`${endpoint}/${id}`,{
        method:"delete"
    }).then(res =>{
        if(res.status===204){
            location.reload();
        }
        else{
            alert("Bi loi");
        }
    })
    }
}