;
//判断对象是否为空 或字符串是否为空字符串
function isNullOrEmpty(obj){
	if(obj==null){
		return true;
	}
	
	//是否是字符串
	if(Object.prototype.toString.call(obj) === "[object String]")
	{
		return $.trim(obj).length==0;
	}else{
		return false;
	}
}

function isString(obj){
	return Object.prototype.toString.call(obj) === "[object String]";
}

phoneRegex=/^(13|14|15|17|18)[0-9]{9}$/;
emailRegex=/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;

//验证邮箱格式
function isCorrectEmail(obj)
{
	if(isNullOrEmpty(obj))
	{
		return false;
	}
	
	return emailRegex.test(obj);
}

//验证手机格式
function isCorrectPhone(obj)
{
	if(isNullOrEmpty(obj))
	{
		return false;
	}
	
	return phoneRegex.test(obj);
}

function string2Json(jsonStr){
	if(isNullOrEmpty(jsonStr)){
		return [];
	}
	
	if(!isString(jsonStr)){
		throw new Error("param is not a string.");
	}
	
	return eval('('+jsonStr+')');
}

function isNotNullOrEmptyArray(arr){
	return arr!=null&&arr.length>0;
}

// ^[a-zA-Z0-9_/u4e00-/u9fa5]+$
function isNormalRegex(text){
	return /^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$/.test(text);
}