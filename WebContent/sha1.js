

var hexcase = 0;
var b64pad = "";
var chrsz = 8;

function hex_sha1(s){
	return binb2hex(core_sha1(str2binb(s),s.length*chrsz));
}

function b64_sha1(s){
	return binb2b64(core_sha1(str2binb(s),s.length*chrsz));
}

function str_sha1(s){
	return binb2str(core_sha1(str2binb(s),s.length*chrsz));
}

function hex_hmac_sha1(key,data){
	return binb2hex(core_hmac_sha1(key,data));
}

function b64_hmac_sha1(key,data){
	return binb2b64(core_hmac_sha1(key,data));
}

function str_hmac_sha1(key,data){
	return binb2str(core_hmac_sha1(key,data));
}


function core_sha1(x,len){
	x[len>>5]=0x80 << (24-len%32);
	x[((len+64>>9)<<4)+15]=len;
	
	var w = Array(80);
	var a = 1732584193;
	var b = -271733879;
	var c = -1732584194;
	var d = 271733878;
	var e = -1009589776;
	
	for(var i=0;i<x.length;i+=16){
		var olda=a;
		var oldb=b;
		var oldc=c;
		var oldd=d;
		var olde=e;
		
		for(var j=0;j<80;j++){
			if(j<16){
				w[j]=x[i+j];
			}
			else{
				w[j]=rol(w[j-3]^w[j-8]^w[j-14]^w[j-16],1);
			}
			
			var t =safe_add(safe_add(rol(a,5),sha1_ft(j,b,c,d)),safe_add(safe_add(e,w[j]),sha1_kt(j)));
			
			e=d;
			d=c;
			c=rol(b,30);
			b=a;
			a=t;
		}
		
		a=safe_add(a,olda);
		b=safe_add(b,oldb);
		c=safe_add(c,oldc);
		d=safe_add(d,oldd);
		e=safe_add(e,olde);
	}
	
	return Array(a,b,c,d,e);
}

function sha1_ft(t,b,c,d){
	if(t<20){
		return (b&c)|((~b)&d);
	}
	
	if(t<40){
		return b^c^d;
	}
	
	if(t<60){
		return (b&c)|(b&d)|(c&d);
	}
	
	return b^c^d;
}

function sha1_kt(t){
	
}


