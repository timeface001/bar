;
    function isNotNullOrEmpty (obj){
        if(obj==undefined){
           return false;
        }

        if(obj==null){
            return false;
        }

        if(typeof obj == "string"){
            return $.trim(obj).length>0;
        }

        if(obj instanceof  Array){
            return obj.length>0;
        }

        return true;
    }

function isNullOrEmpty (obj){

    return !isNotNullOrEmpty(obj);
}
