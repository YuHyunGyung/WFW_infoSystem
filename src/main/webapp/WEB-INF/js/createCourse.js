$(document).ready(function(){
    //교과코드 select box

    var code = ["GEN0713", "GEN0631", "REQ0311", "REQ0021", "REQ0018", "GEN0656"
        ,"CTE0019", "CTE0002", "GEN0776", "GEN0727", "REQ0421", "REQ0024", "REQ0022", "CCA0005"
        ,"V020005", "V020004", "V020003", "V020002", "V020001", "GEN0698", "GEN0686"
        ,"V020011", "V020010", "V020008", "V020007", "V024003", "V021003"
        ,"V020015", "V020014", "V020012", "V024004", "V021004"
        ,"V023005", "V020018", "V020017", "V024005", "V021006"];

    for(var i=0; code; i++) {
        $('#courseId').append('<option value="'+i+'">code[i]</option>');
    }

})