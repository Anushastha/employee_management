var departmentList = document.getElementsByName("departmentList");
var salary = document.getElementsByName("salary");

function pay(){
    if(departmentList == "Chief Executive"){
        return salary=200000;
    }
    else if(departmentList=="Manager"){
        return salary=100000;
    }
    else if(departmentList=="Director"){
        return salary=150000;
    }
    else if(departmentList=="Assistant"){
        return salary=80000;
    }
    else if(departmentList=="Staff"){
        return salary=40000;
    }

}