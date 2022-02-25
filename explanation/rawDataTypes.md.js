let mdoc_js_run2,mdoc_js_run4,mdoc_js_run8,mdoc_js_run6,mdoc_js_run3,mdoc_js_run1,mdoc_js_run5,mdoc_js_run7,mdoc_js_run0;
(function(){
'use strict';var f,aa=Object.freeze({esVersion:6,assumingES6:!0,productionMode:!0,linkerVersion:"1.7.0",fileLevelThis:this}),k=Math.imul,ba=Math.clz32,ca;function da(a){for(var b in a)return b}function l(a){this.Ra=a}l.prototype.toString=function(){return String.fromCharCode(this.Ra)};
function ea(a){switch(typeof a){case "string":return"java.lang.String";case "number":return"number"===typeof a&&(a|0)===a&&1/a!==1/-0?a<<24>>24===a?"java.lang.Byte":a<<16>>16===a?"java.lang.Short":"java.lang.Integer":"java.lang.Float";case "boolean":return"java.lang.Boolean";case "undefined":return"java.lang.Void";default:return null===a?a.cd():a instanceof n?"java.lang.Long":a instanceof l?"java.lang.Character":a&&a.$classData?a.$classData.name:null.dd()}}
function fa(a,b){switch(typeof a){case "string":return a===b;case "number":return Object.is(a,b);case "boolean":return a===b;case "undefined":return a===b;default:return a&&a.$classData||null===a?b=a.w(b):a instanceof n?b instanceof n?(a=p(a),b=p(b),b=a.l===b.l&&a.k===b.k):b=!1:b=a instanceof l?b instanceof l?q(a)===q(b):!1:r.prototype.w.call(a,b),b}}
function ha(a){switch(typeof a){case "string":return u(a);case "number":return ia(a);case "boolean":return a?1231:1237;case "undefined":return 0;default:return a&&a.$classData||null===a?a=a.z():a instanceof n?(a=p(a),a=a.l^a.k):a=a instanceof l?q(a):r.prototype.z.call(a),a}}function ja(a){return void 0===a?"undefined":a.toString()}var ka=0,la=new WeakMap;
function ma(a){switch(typeof a){case "string":return u(a);case "number":return ia(a);case "bigint":var b=0;for(a<BigInt(0)&&(a=~a);a!==BigInt(0);)b^=Number(BigInt.asIntN(32,a)),a>>=BigInt(32);return b;case "boolean":return a?1231:1237;case "undefined":return 0;case "symbol":return a=a.description,void 0===a?0:u(a);default:if(null===a)return 0;b=la.get(a);void 0===b&&(ka=b=ka+1|0,la.set(a,b));return b}}function q(a){return null===a?0:a.Ra}function p(a){return null===a?ca:a}function r(){}
r.prototype.constructor=r;function v(){}v.prototype=r.prototype;r.prototype.z=function(){return ma(this)};r.prototype.w=function(a){return this===a};r.prototype.j=function(){var a=this.z();return ea(this)+"@"+(+(a>>>0)).toString(16)};r.prototype.toString=function(){return this.j()};function w(a){if("number"===typeof a){this.d=Array(a);for(var b=0;b<a;b++)this.d[b]=null}else this.d=a}w.prototype=new v;w.prototype.constructor=w;function na(){}na.prototype=w.prototype;
function oa(a){if("number"===typeof a){this.d=Array(a);for(var b=0;b<a;b++)this.d[b]=!1}else this.d=a}oa.prototype=new v;oa.prototype.constructor=oa;function pa(a){this.d="number"===typeof a?new Uint16Array(a):a}pa.prototype=new v;pa.prototype.constructor=pa;function qa(a){this.d="number"===typeof a?new Int8Array(a):a}qa.prototype=new v;qa.prototype.constructor=qa;function ra(a){this.d="number"===typeof a?new Int16Array(a):a}ra.prototype=new v;ra.prototype.constructor=ra;
function sa(a){this.d="number"===typeof a?new Int32Array(a):a}sa.prototype=new v;sa.prototype.constructor=sa;function ta(a){if("number"===typeof a){this.d=Array(a);for(var b=0;b<a;b++)this.d[b]=ca}else this.d=a}ta.prototype=new v;ta.prototype.constructor=ta;function ua(a){this.d="number"===typeof a?new Float32Array(a):a}ua.prototype=new v;ua.prototype.constructor=ua;function va(a){this.d="number"===typeof a?new Float64Array(a):a}va.prototype=new v;va.prototype.constructor=va;
function wa(){this.G=void 0;this.W=this.q=null;this.X=0;this.sb=null;this.F="";this.O=this.V=void 0;this.name="";this.isJSClass=this.isArrayClass=this.isInterface=this.isPrimitive=!1;this.isInstance=void 0}function x(a,b,c,d){var g=new wa;g.q={};g.sb=a;g.F=b;g.O=e=>e===g;g.name=c;g.isPrimitive=!0;g.isInstance=()=>!1;void 0!==d&&(g.V=xa(g,d));return g}
function y(a,b,c){var d=new wa,g=da(a);d.q=c;d.F="L"+b+";";d.O=e=>!!e.q[g];d.name=b;d.isInterface=!1;d.isInstance=e=>!!(e&&e.$classData&&e.$classData.q[g]);return d}function xa(a,b,c){var d=new wa;b.prototype.$classData=d;var g="["+a.F;d.G=b;d.q={a:1,Aa:1,c:1};d.W=a;d.X=1;d.F=g;d.name=g;d.isArrayClass=!0;d.O=c||(e=>d===e);d.isInstance=e=>e instanceof b;return d}
function ya(a){function b(h){if("number"===typeof h){this.d=Array(h);for(var m=0;m<h;m++)this.d[m]=null}else this.d=h}var c=new wa;b.prototype=new na;b.prototype.constructor=b;var d=a.W||a,g=a.X+1;b.prototype.$classData=c;a="["+a.F;c.G=b;c.q={a:1,Aa:1,c:1};c.W=d;c.X=g;c.F=a;c.name=a;c.isArrayClass=!0;var e=h=>{var m=h.X;return m===g?d.O(h.W):m>g&&d===z};c.O=e;c.isInstance=h=>{h=h&&h.$classData;return!!h&&(h===c||e(h))};return c}function A(a){a.V||(a.V=ya(a));return a.V}var z=new wa;z.q={a:1};
z.F="Ljava.lang.Object;";z.O=a=>!a.isPrimitive;z.name="java.lang.Object";z.isInstance=a=>null!==a;z.V=xa(z,w,a=>{var b=a.X;return 1===b?!a.W.isPrimitive:1<b});r.prototype.$classData=z;x(void 0,"V","void",void 0);x(!1,"Z","boolean",oa);x(0,"C","char",pa);x(0,"B","byte",qa);x(0,"S","short",ra);x(0,"I","int",sa);var za=x(null,"J","long",ta);x(0,"F","float",ua);x(0,"D","double",va);
function Aa(){this.Wa=this.la=this.Y=null;Ba=this;this.Y=new ArrayBuffer(8);this.la=new Int32Array(this.Y,0,2);new Float32Array(this.Y,0,2);this.Wa=new Float64Array(this.Y,0,1);this.la[0]=16909060;new Int8Array(this.Y,0,8)}Aa.prototype=new v;Aa.prototype.constructor=Aa;function Ca(a,b){var c=b|0;if(c===b&&-Infinity!==1/b)return c;a.Wa[0]=b;return(a.la[0]|0)^(a.la[1]|0)}Aa.prototype.$classData=y({Ab:0},"java.lang.FloatingPointBits$",{Ab:1,a:1});var Ba;function Da(){Ba||(Ba=new Aa);return Ba}
function Ea(){this.Ya=this.Ba=null;Fa=this;var a={"java.version":"1.8","java.vm.specification.version":"1.8","java.vm.specification.vendor":"Oracle Corporation","java.vm.specification.name":"Java Virtual Machine Specification","java.vm.name":"Scala.js"};a["java.vm.version"]=aa.linkerVersion;a["java.specification.version"]="1.8";a["java.specification.vendor"]="Oracle Corporation";a["java.specification.name"]="Java Platform API Specification";a["file.separator"]="/";a["path.separator"]=":";a["line.separator"]=
"\n";this.Ba=a;this.Ya=null}Ea.prototype=new v;Ea.prototype.constructor=Ea;function Ga(a,b,c){null!==a.Ba?(Ha||(Ha=new Ia),a=a.Ba,Ja||(Ja=new Ka),b=Ja.$a.call(a,b)?a[b]:c):b=Ga(a.Ya,b,c);return b}Ea.prototype.$classData=y({Gb:0},"java.lang.System$SystemProperties$",{Gb:1,a:1});var Fa;function Ia(){}Ia.prototype=new v;Ia.prototype.constructor=Ia;Ia.prototype.$classData=y({Lb:0},"java.lang.Utils$",{Lb:1,a:1});var Ha;function Ka(){this.$a=null;Ja=this;this.$a=Object.prototype.hasOwnProperty}
Ka.prototype=new v;Ka.prototype.constructor=Ka;Ka.prototype.$classData=y({Mb:0},"java.lang.Utils$Cache$",{Mb:1,a:1});var Ja;function La(){}La.prototype=new v;La.prototype.constructor=La;La.prototype.$classData=y({Nb:0},"java.util.Arrays$",{Nb:1,a:1});var Ma;function Na(){}Na.prototype=new v;Na.prototype.constructor=Na;Na.prototype.$classData=y({tb:0},"mdocjs$",{tb:1,a:1});var Oa;function B(){Oa||(Oa=new Na)}function n(a,b){this.l=a;this.k=b}n.prototype=new v;n.prototype.constructor=n;
n.prototype.w=function(a){return a instanceof n?this.l===a.l&&this.k===a.k:!1};n.prototype.z=function(){return this.l^this.k};n.prototype.j=function(){Pa();var a=this.l,b=this.k;return b===a>>31?""+a:0>b?"-"+Qa(-a|0,0!==a?~b:-b|0):Qa(a,b)};n.prototype.$classData=y({vb:0},"org.scalajs.linker.runtime.RuntimeLong",{vb:1,a:1});
function Qa(a,b){if(0===(-2097152&b))b=""+(4294967296*b+ +(a>>>0));else{var c=(32+ba(1E9)|0)-(0!==b?ba(b):32+ba(a)|0)|0,d=c,g=0===(32&d)?1E9<<d:0;d=0===(32&d)?5E8>>>(31-d|0)|0|0<<d:1E9<<d;var e=a,h=b;for(a=b=0;0<=c&&0!==(-2097152&h);){var m=e,t=h,Xb=g,M=d;if(t===M?(-2147483648^m)>=(-2147483648^Xb):(-2147483648^t)>=(-2147483648^M))m=h,t=d,h=e-g|0,m=(-2147483648^h)>(-2147483648^e)?-1+(m-t|0)|0:m-t|0,e=h,h=m,32>c?b|=1<<c:a|=1<<c;c=-1+c|0;m=d>>>1|0;g=g>>>1|0|d<<31;d=m}c=h;if(0===c?-1147483648<=(-2147483648^
e):-2147483648<=(-2147483648^c))c=4294967296*h+ +(e>>>0),e=c/1E9,g=e/4294967296|0,d=b,b=e=d+(e|0)|0,a=(-2147483648^e)<(-2147483648^d)?1+(a+g|0)|0:a+g|0,e=c%1E9|0;c=""+e;b=""+(4294967296*a+ +(b>>>0))+"000000000".substring(c.length|0)+c}return b}function Ra(){this.fa=0}Ra.prototype=new v;Ra.prototype.constructor=Ra;function Sa(a,b,c){return 0>c?-(4294967296*+((0!==b?~c:-c|0)>>>0)+ +((-b|0)>>>0)):4294967296*c+ +(b>>>0)}
Ra.prototype.$classData=y({wb:0},"org.scalajs.linker.runtime.RuntimeLong$",{wb:1,a:1});var Ta;function Pa(){Ta||(Ta=new Ra);return Ta}function Ua(a,b,c,d){if(a.e())a=""+b+d;else{var g=a.ga,e=new Va;e.v=Wa(new C);a=g.call(a,e,b,c,d).v.b}return a}function Xa(a,b,c,d,g){var e=b.v;0!==(c.length|0)&&(e.b=""+e.b+c);a=a.o();if(a.h())for(c=a.i(),e.b=""+e.b+c;a.h();)e.b=""+e.b+d,c=a.i(),e.b=""+e.b+c;0!==(g.length|0)&&(e.b=""+e.b+g);return b}
function Ya(){this.rb=null;Za=this;this.rb=new w(0);new (A(A(z)).G)(0);new (A(A(A(z))).G)(0);new (A(A(A(A(z)))).G)(0);new (A(A(A(A(A(z))))).G)(0);new (A(A(A(A(A(A(z)))))).G)(0)}Ya.prototype=new v;Ya.prototype.constructor=Ya;Ya.prototype.$classData=y({Rc:0},"scala.collection.immutable.VectorStatics$",{Rc:1,a:1});var Za;function $a(){Za||(Za=new Ya);return Za}function ab(){}ab.prototype=new v;ab.prototype.constructor=ab;
ab.prototype.$classData=y({rc:0},"scala.collection.package$$colon$plus$",{rc:1,a:1});var bb;function cb(){}cb.prototype=new v;cb.prototype.constructor=cb;cb.prototype.$classData=y({sc:0},"scala.collection.package$$plus$colon$",{sc:1,a:1});var db;function eb(){}eb.prototype=new v;eb.prototype.constructor=eb;eb.prototype.$classData=y({Yb:0},"scala.math.Ordered$",{Yb:1,a:1});var fb;
function gb(){this.db=null;hb=this;ib||(ib=new D);ib||(ib=new D);jb||(jb=new kb);lb||(lb=new mb);E();nb();this.db=ob();pb||(pb=new qb);db||(db=new cb);bb||(bb=new ab);rb||(rb=new sb);F();tb();ub||(ub=new vb);wb||(wb=new xb);yb||(yb=new zb);Ab||(Ab=new Bb);Cb||(Cb=new Db);Eb||(Eb=new Fb);fb||(fb=new eb);Gb||(Gb=new Hb);Ib||(Ib=new Jb);Kb||(Kb=new Lb);Pb||(Pb=new Qb)}gb.prototype=new v;gb.prototype.constructor=gb;gb.prototype.$classData=y({$b:0},"scala.package$",{$b:1,a:1});var hb;function Rb(){}
Rb.prototype=new v;Rb.prototype.constructor=Rb;function G(a,b,c){if(b===c)c=!0;else if(Sb(b))a:if(Sb(c))c=Tb(b,c);else{if(c instanceof l){if("number"===typeof b){c=+b===q(c);break a}if(b instanceof n){a=p(b);b=a.k;c=q(c);c=a.l===c&&b===c>>31;break a}}c=null===b?null===c:fa(b,c)}else c=b instanceof l?Ub(b,c):null===b?null===c:fa(b,c);return c}
function Tb(a,b){if("number"===typeof a){a=+a;if("number"===typeof b)return a===+b;if(b instanceof n){var c=p(b);b=c.l;c=c.k;return a===Sa(Pa(),b,c)}return!1}if(a instanceof n){c=p(a);a=c.l;c=c.k;if(b instanceof n){b=p(b);var d=b.k;return a===b.l&&c===d}return"number"===typeof b?(b=+b,Sa(Pa(),a,c)===b):!1}return null===a?null===b:fa(a,b)}
function Ub(a,b){if(b instanceof l)return q(a)===q(b);if(Sb(b)){if("number"===typeof b)return+b===q(a);if(b instanceof n){b=p(b);var c=b.k;a=q(a);return b.l===a&&c===a>>31}return null===b?null===a:fa(b,a)}return null===a&&null===b}Rb.prototype.$classData=y({Yc:0},"scala.runtime.BoxesRunTime$",{Yc:1,a:1});var Vb;function H(){Vb||(Vb=new Rb);return Vb}function Wb(){}Wb.prototype=new v;Wb.prototype.constructor=Wb;
function I(a,b){if(null===b)return 0;if("number"===typeof b){a=+b;b=2147483647<a?2147483647:-2147483648>a?-2147483648:a|0;if(b===a)a=b;else{b=Pa();if(-0x7fffffffffffffff>a){b.fa=-2147483648;var c=0}else if(0x7fffffffffffffff<=a)b.fa=2147483647,c=-1;else{c=a|0;var d=a/4294967296|0;b.fa=0>a&&0!==c?-1+d|0:d}b=b.fa;a=Sa(Pa(),c,b)===a?c^b:Ca(Da(),a)}return a}return b instanceof n?(a=p(b),b=new n(a.l,a.k),a=b.l,b=b.k,b===a>>31?a:a^b):ha(b)}
Wb.prototype.$classData=y({ad:0},"scala.runtime.Statics$",{ad:1,a:1});var Yb;function J(){Yb||(Yb=new Wb);return Yb}function Zb(){}Zb.prototype=new v;Zb.prototype.constructor=Zb;Zb.prototype.$classData=y({Xc:0},"scala.scalajs.runtime.package$",{Xc:1,a:1});var $b;function ac(){}ac.prototype=new v;ac.prototype.constructor=ac;function bc(){}bc.prototype=ac.prototype;function K(a,b){a=cc(a,b);return-430675100+k(5,a<<13|a>>>19|0)|0}
function cc(a,b){b=k(-862048943,b);b=k(461845907,b<<15|b>>>17|0);return a^b}function L(a){a=k(-2048144789,a^(a>>>16|0));a=k(-1028477387,a^(a>>>13|0));return a^(a>>>16|0)}function dc(){}dc.prototype=new v;dc.prototype.constructor=dc;
function N(a,b,c,d){a=document.createElement("div");var g=ec();g="vega"+Ua(g,"","","");a.id=g;c.appendChild(a);a.setAttribute("style","width:"+d+"vmin;height:"+d+"vmin");(0,eval)("\n            vegaEmbed('#"+g+"', \"../assets/"+b+'.json", {\n                renderer: "canvas", // renderer (canvas or svg)\n                container: "#'+g+'", // parent DOM container\n                hover: true, // enable hover processing\n                actions: {\n                    editor : true\n                }\n            }).then(function(result) {\n            console.log(result)\n            })')}
dc.prototype.$classData=y({ub:0},"viz.doc.showJsDocs$",{ub:1,a:1});var fc;function O(){fc||(fc=new dc);return fc}function gc(a){0===(32&a.ka)<<24>>24&&0===(32&a.ka)<<24>>24&&(a.Va=new sa(new Int32Array([1632,1776,1984,2406,2534,2662,2790,2918,3046,3174,3302,3430,3664,3792,3872,4160,4240,6112,6160,6470,6608,6784,6800,6992,7088,7232,7248,42528,43216,43264,43472,43600,44016,65296,66720,69734,69872,69942,70096,71360,120782,120792,120802,120812,120822])),a.ka=(32|a.ka)<<24>>24);return a.Va}
function hc(){this.Va=null;this.ka=0}hc.prototype=new v;hc.prototype.constructor=hc;hc.prototype.$classData=y({zb:0},"java.lang.Character$",{zb:1,a:1,c:1});var ic;function jc(a){throw new kc('For input string: "'+a+'"');}function lc(){}lc.prototype=new v;lc.prototype.constructor=lc;lc.prototype.$classData=y({Cb:0},"java.lang.Integer$",{Cb:1,a:1,c:1});var mc;function Sb(a){return"number"===typeof a||a instanceof n}function P(a,b){a.Za=b;a.Hb=null;a.Ib=!0;a.Jb=!0;a.Ua()}
class nc extends Error{constructor(){super();this.Hb=this.Za=null;this.Jb=this.Ib=!1}ja(){return this.Za}Ua(){"[object Error]"!==Object.prototype.toString.call(this)&&void 0!==Error.captureStackTrace&&Error.captureStackTrace(this)}j(){var a=ea(this),b=this.ja();return null===b?a:a+": "+b}z(){return r.prototype.z.call(this)}w(a){return r.prototype.w.call(this,a)}get ["message"](){var a=this.ja();return null===a?"":a}get ["name"](){return ea(this)}["toString"](){return this.j()}}
function oc(){this.Da=this.Ca=0;this.Rb=!1}oc.prototype=new v;oc.prototype.constructor=oc;function pc(a){var b=a.Da,c=15525485*b+11;b=16777215&((c/16777216|0)+(16777215&(1502*b+15525485*a.Ca|0))|0);c=16777215&(c|0);a.Ca=b;a.Da=c;return(b<<8|c>>16)>>>1|0}oc.prototype.$classData=y({Pb:0},"java.util.Random",{Pb:1,a:1,c:1});function rc(){var a=4294967296*+Math.random();a=+Math.floor(a)-2147483648;return 2147483647<a?2147483647:-2147483648>a?-2147483648:a|0}function sc(){}sc.prototype=new v;
sc.prototype.constructor=sc;sc.prototype.$classData=y({Qb:0},"java.util.Random$",{Qb:1,a:1,c:1});var tc;function qb(){}qb.prototype=new v;qb.prototype.constructor=qb;qb.prototype.j=function(){return"::"};qb.prototype.$classData=y({uc:0},"scala.collection.immutable.$colon$colon$",{uc:1,a:1,c:1});var pb;function xb(){}xb.prototype=new v;xb.prototype.constructor=xb;xb.prototype.$classData=y({Lc:0},"scala.collection.immutable.Range$",{Lc:1,a:1,c:1});var wb;function vb(){}vb.prototype=new v;
vb.prototype.constructor=vb;vb.prototype.$classData=y({Tc:0},"scala.collection.mutable.StringBuilder$",{Tc:1,a:1,c:1});var ub;function Bb(){}Bb.prototype=new v;Bb.prototype.constructor=Bb;Bb.prototype.$classData=y({Vb:0},"scala.math.Fractional$",{Vb:1,a:1,c:1});var Ab;function Db(){}Db.prototype=new v;Db.prototype.constructor=Db;Db.prototype.$classData=y({Wb:0},"scala.math.Integral$",{Wb:1,a:1,c:1});var Cb;function Fb(){}Fb.prototype=new v;Fb.prototype.constructor=Fb;
Fb.prototype.$classData=y({Xb:0},"scala.math.Numeric$",{Xb:1,a:1,c:1});var Eb;function uc(){}uc.prototype=new v;uc.prototype.constructor=uc;function vc(){}vc.prototype=uc.prototype;uc.prototype.j=function(){return"\x3cfunction0\x3e"};function wc(a){this.Pa=a}wc.prototype=new v;wc.prototype.constructor=wc;wc.prototype.j=function(){return""+this.Pa};wc.prototype.$classData=y({Zc:0},"scala.runtime.IntRef",{Zc:1,a:1,c:1});function xc(a){this.Qa=a}xc.prototype=new v;xc.prototype.constructor=xc;
xc.prototype.j=function(){return""+this.Qa};xc.prototype.$classData=y({$c:0},"scala.runtime.ObjectRef",{$c:1,a:1,c:1});function Jb(){}Jb.prototype=new v;Jb.prototype.constructor=Jb;Jb.prototype.$classData=y({ac:0},"scala.util.Either$",{ac:1,a:1,c:1});var Ib;function Lb(){}Lb.prototype=new v;Lb.prototype.constructor=Lb;Lb.prototype.j=function(){return"Left"};Lb.prototype.$classData=y({bc:0},"scala.util.Left$",{bc:1,a:1,c:1});var Kb;function yc(){this.Ha=null}yc.prototype=new v;
yc.prototype.constructor=yc;function zc(){}zc.prototype=yc.prototype;function Ac(){Bc||(Bc=new Cc);var a=Bc;return Dc(F(),new Q((b=>()=>{var c=b.Ha;var d=62;if(0>=d)throw c=new Ec,P(c,"n must be positive"),c;if((d&(-d|0))===d)c=pc(c)>>ba(d);else a:for(;;){var g=pc(c);var e=g;var h=d;if(0===h)throw new Fc;e=e%h|0;if(!(0>((g-e|0)+(-1+d|0)|0))){c=e;break a}}c=65535&("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charCodeAt(c)|0);return new l(c)})(a)))}function Qb(){}Qb.prototype=new v;
Qb.prototype.constructor=Qb;Qb.prototype.j=function(){return"Right"};Qb.prototype.$classData=y({dc:0},"scala.util.Right$",{dc:1,a:1,c:1});var Pb;function Gc(){this.eb=this.oa=0;Hc=this;this.oa=u("Seq");this.eb=u("Map");u("Set");hb||(hb=new gb);for(var a=this.eb,b=0,c=0,d=0,g=1,e=hb.db.o();e.h();){var h=e.i();h=I(J(),h);b=b+h|0;c^=h;g=k(g,1|h);d=1+d|0}a=K(a,b);a=K(a,c);a=cc(a,g);L(a^d)}Gc.prototype=new bc;Gc.prototype.constructor=Gc;
Gc.prototype.$classData=y({ec:0},"scala.util.hashing.MurmurHash3$",{ec:1,jd:1,a:1});var Hc;function Ic(){Hc||(Hc=new Gc);return Hc}class Jc extends nc{}function Kc(){}Kc.prototype=new v;Kc.prototype.constructor=Kc;function Lc(){}Lc.prototype=Kc.prototype;function Mc(){this.P=null;Nc=this;this.P=new R}Mc.prototype=new v;Mc.prototype.constructor=Mc;Mc.prototype.$classData=y({kc:0},"scala.collection.Iterator$",{kc:1,a:1,A:1,c:1});var Nc;function E(){Nc||(Nc=new Mc);return Nc}
function S(a,b){this.Cc=a;this.Dc=b}S.prototype=new v;S.prototype.constructor=S;S.prototype.n=function(){return this.Cc};S.prototype.g=function(){return this.Dc};S.prototype.$classData=y({Bc:0},"scala.collection.immutable.LazyList$State$Cons",{Bc:1,a:1,Ac:1,c:1});function T(){}T.prototype=new v;T.prototype.constructor=T;T.prototype.N=function(){throw new Oc("head of empty lazy list");};T.prototype.g=function(){throw new Pc("tail of empty lazy list");};T.prototype.n=function(){this.N()};
T.prototype.$classData=y({Ec:0},"scala.collection.immutable.LazyList$State$Empty$",{Ec:1,a:1,Ac:1,c:1});var Qc;function Rc(){Qc||(Qc=new T);return Qc}function zb(){}zb.prototype=new v;zb.prototype.constructor=zb;zb.prototype.$classData=y({Ub:0},"scala.math.Equiv$",{Ub:1,a:1,fd:1,c:1});var yb;function Hb(){}Hb.prototype=new v;Hb.prototype.constructor=Hb;Hb.prototype.$classData=y({Zb:0},"scala.math.Ordering$",{Zb:1,a:1,gd:1,c:1});var Gb;function Q(a){this.Wc=a}Q.prototype=new vc;
Q.prototype.constructor=Q;function Sc(a){return(0,a.Wc)()}Q.prototype.$classData=y({Vc:0},"scala.scalajs.runtime.AnonFunction0",{Vc:1,Hd:1,a:1,bd:1});function Cc(){this.Ha=null;var a=new oc;tc||(tc=new sc);var b=rc();var c=rc();b=new n(c,b);c=-554899859^b.l;a.Ca=c>>>24|0|(65535&(5^b.k))<<8;a.Da=16777215&c;a.Rb=!1;this.Ha=a}Cc.prototype=new zc;Cc.prototype.constructor=Cc;Cc.prototype.$classData=y({cc:0},"scala.util.Random$",{cc:1,hd:1,a:1,c:1});var Bc;class U extends Jc{}
U.prototype.$classData=y({t:0},"java.lang.RuntimeException",{t:1,x:1,y:1,a:1,c:1});function Wa(a){a.b="";return a}function C(){this.b=null}C.prototype=new v;C.prototype.constructor=C;C.prototype.j=function(){return this.b};C.prototype.f=function(){return this.b.length|0};C.prototype.$classData=y({Fb:0},"java.lang.StringBuilder",{Fb:1,a:1,yb:1,ed:1,c:1});function Tc(){}Tc.prototype=new v;Tc.prototype.constructor=Tc;function Uc(){}f=Uc.prototype=Tc.prototype;f.o=function(){return this};f.e=function(){return!this.h()};
f.ia=function(a){for(var b=0;b<a&&this.h();)this.i(),b=1+b|0;return this};f.j=function(){return"\x3citerator\x3e"};f.ga=function(a,b,c,d){return Xa(this,a,b,c,d)};f.u=function(){return-1};function D(){Vc||(Vc=new Wc)}D.prototype=new Lc;D.prototype.constructor=D;D.prototype.$classData=y({ic:0},"scala.collection.Iterable$",{ic:1,jc:1,a:1,A:1,c:1});var ib;function Xc(){}Xc.prototype=new v;Xc.prototype.constructor=Xc;function Yc(){}Yc.prototype=Xc.prototype;
function Zc(a,b){var c=a.u();if(-1!==c){var d=b.u();c=-1!==d&&c!==d}else c=!1;if(c)return!1;a:{a=a.o();for(b=b.o();a.h()&&b.h();)if(!G(H(),a.i(),b.i())){b=!1;break a}b=a.h()===b.h()}return b}function Wc(){nb()}Wc.prototype=new Lc;Wc.prototype.constructor=Wc;Wc.prototype.$classData=y({wc:0},"scala.collection.immutable.Iterable$",{wc:1,jc:1,a:1,A:1,c:1});var Vc;function $c(){this.xa=null;ad=this;this.xa=bd(new V(new Q((()=>()=>Rc())(this))))}$c.prototype=new v;$c.prototype.constructor=$c;
function cd(a,b,c){return new V(new Q(((d,g,e)=>()=>{for(var h=g.Qa,m=e.Pa;0<m&&!h.e();)h=W(h).g(),g.Qa=h,m=-1+m|0,e.Pa=m;return W(h)})(a,new xc(b),new wc(c))))}function Dc(a,b){return new V(new Q(((c,d)=>()=>{F();var g=Sc(d),e=Dc(F(),d);return new S(g,e)})(a,b)))}$c.prototype.$classData=y({yc:0},"scala.collection.immutable.LazyList$",{yc:1,a:1,aa:1,A:1,c:1});var ad;function F(){ad||(ad=new $c);return ad}function sb(){}sb.prototype=new v;sb.prototype.constructor=sb;
sb.prototype.$classData=y({Nc:0},"scala.collection.immutable.Stream$",{Nc:1,a:1,aa:1,A:1,c:1});var rb;class Fc extends U{constructor(){super();P(this,"/ by zero")}}Fc.prototype.$classData=y({xb:0},"java.lang.ArithmeticException",{xb:1,t:1,x:1,y:1,a:1,c:1});class Ec extends U{}Ec.prototype.$classData=y({Xa:0},"java.lang.IllegalArgumentException",{Xa:1,t:1,x:1,y:1,a:1,c:1});class dd extends U{constructor(a){super();P(this,a)}}
dd.prototype.$classData=y({Bb:0},"java.lang.IndexOutOfBoundsException",{Bb:1,t:1,x:1,y:1,a:1,c:1});y({Db:0},"java.lang.NullPointerException",{Db:1,t:1,x:1,y:1,a:1,c:1});class Pc extends U{constructor(a){super();P(this,a)}}Pc.prototype.$classData=y({Kb:0},"java.lang.UnsupportedOperationException",{Kb:1,t:1,x:1,y:1,a:1,c:1});class Oc extends U{constructor(a){super();P(this,a)}}Oc.prototype.$classData=y({Ob:0},"java.util.NoSuchElementException",{Ob:1,t:1,x:1,y:1,a:1,c:1});
class ed extends U{constructor(a){super();this.cb=null;this.Fa=!1;this.na=a;P(this,null)}ja(){if(!this.Fa&&!this.Fa){if(null===this.na)var a="null";else try{a=ja(this.na)+" (of class "+ea(this.na)+")"}catch(b){if($b||($b=new Zb),null!==(b instanceof nc?b:new fd(b)))a="an instance of class "+ea(this.na);else throw b;}this.cb=a;this.Fa=!0}return this.cb}}ed.prototype.$classData=y({Sb:0},"scala.MatchError",{Sb:1,t:1,x:1,y:1,a:1,c:1});function R(){}R.prototype=new Uc;R.prototype.constructor=R;
R.prototype.h=function(){return!1};R.prototype.u=function(){return 0};R.prototype.i=function(){throw new Oc("next on empty iterator");};R.prototype.$classData=y({lc:0},"scala.collection.Iterator$$anon$19",{lc:1,fb:1,a:1,Ja:1,B:1,C:1});function gd(a,b){if(0>b)throw new dd(""+b);a=a.Ta(b);if(a.e())throw new dd(""+b);return a.n()}
function hd(a,b){if(b&&b.$classData&&b.$classData.q.ib)a:for(;;){if(a===b){a=!0;break a}if((a.e()?0:!b.e())&&G(H(),a.n(),b.n()))a=a.U(),b=b.U();else{a=a.e()&&b.e();break a}}else a=Zc(a,b);return a}function mb(){tb()}mb.prototype=new Yc;mb.prototype.constructor=mb;mb.prototype.$classData=y({vc:0},"scala.collection.immutable.IndexedSeq$",{vc:1,nc:1,a:1,aa:1,A:1,c:1});var lb;function X(a){this.ba=a}X.prototype=new Uc;X.prototype.constructor=X;X.prototype.h=function(){return!this.ba.e()};
X.prototype.i=function(){if(this.ba.e())return E().P.i();var a=W(this.ba).n();this.ba=W(this.ba).g();return a};X.prototype.$classData=y({zc:0},"scala.collection.immutable.LazyList$LazyIterator",{zc:1,fb:1,a:1,Ja:1,B:1,C:1});function id(){jd=this;ob();ob()}id.prototype=new v;id.prototype.constructor=id;id.prototype.$classData=y({Hc:0},"scala.collection.immutable.List$",{Hc:1,a:1,pc:1,aa:1,A:1,c:1});var jd;function nb(){jd||(jd=new id)}
function kd(a){a.p<=a.m&&E().P.i();a.da=1+a.da|0;for(var b=null;0===b.d.length;)a.da=1+a.da|0,b=null;a.ya=a.R;var c=a.Jc/2|0,d=a.da-c|0;a.M=(1+c|0)-(0>d?-d|0:d)|0;c=a.M;switch(c){case 1:a.D=b;break;case 2:a.J=b;break;case 3:a.K=b;break;case 4:a.L=b;break;case 5:a.Q=b;break;case 6:a.Na=b;break;default:throw new ed(c);}a.R=a.ya+k(b.d.length,1<<k(5,-1+a.M|0))|0;a.R>a.E&&(a.R=a.E);1<a.M&&(a.ca=-1+(1<<k(5,a.M))|0)}
function ld(a,b,c){this.Na=this.Q=this.L=this.K=this.J=null;this.E=b;this.Jc=c;this.D=a.S;this.I=this.D.d.length;this.ca=this.m=0;this.p=this.E;this.da=0;this.M=1;this.ya=0;this.R=this.I}ld.prototype=new v;ld.prototype.constructor=ld;f=ld.prototype;f.o=function(){return this};f.e=function(){return this.p<=this.m};f.j=function(){return"\x3citerator\x3e"};f.ga=function(a,b,c,d){return Xa(this,a,b,c,d)};f.u=function(){return this.p-this.m|0};f.h=function(){return this.p>this.m};
f.i=function(){if(this.m===this.I){var a=(this.m-this.p|0)+this.E|0;a===this.R&&kd(this);if(1<this.M){a=a-this.ya|0;var b=this.ca^a;1024>b?this.D=this.J.d[31&(a>>>5|0)]:(32768>b?this.J=this.K.d[31&(a>>>10|0)]:(1048576>b?this.K=this.L.d[31&(a>>>15|0)]:(33554432>b?this.L=this.Q.d[31&(a>>>20|0)]:(this.Q=this.Na.d[a>>>25|0],this.L=this.Q.d[0]),this.K=this.L.d[0]),this.J=this.K.d[0]),this.D=this.J.d[0]);this.ca=a}this.p=this.p-this.m|0;a=this.D.d.length;b=this.p;this.I=a<b?a:b;this.m=0}a=this.D.d[this.m];
this.m=1+this.m|0;return a};
f.ia=function(a){if(0<a){a=((this.m-this.p|0)+this.E|0)+a|0;var b=this.E;a=a<b?a:b;if(a===this.E)this.I=this.p=this.m=0;else{for(;a>=this.R;)kd(this);b=a-this.ya|0;if(1<this.M){var c=this.ca^b;1024>c||(32768>c||(1048576>c||(33554432>c||(this.Q=this.Na.d[b>>>25|0]),this.L=this.Q.d[31&(b>>>20|0)]),this.K=this.L.d[31&(b>>>15|0)]),this.J=this.K.d[31&(b>>>10|0)]);this.D=this.J.d[31&(b>>>5|0)];this.ca=b}this.I=this.D.d.length;this.m=31&b;this.p=this.m+(this.E-a|0)|0;this.I>this.p&&(this.I=this.p)}}return this};
f.$classData=y({Ic:0},"scala.collection.immutable.NewVectorIterator",{Ic:1,a:1,Ja:1,B:1,C:1,Aa:1});function kb(){nb()}kb.prototype=new Yc;kb.prototype.constructor=kb;kb.prototype.$classData=y({Mc:0},"scala.collection.immutable.Seq$",{Mc:1,nc:1,a:1,aa:1,A:1,c:1});var jb;
function md(){this.Oa=0;this.qb=null;nd=this;try{var a=Ga;Fa||(Fa=new Ea);var b=a(Fa,"scala.collection.immutable.Vector.defaultApplyPreferredMaxLength","250");mc||(mc=new lc);var c=null===b?0:b.length|0;0===c&&jc(b);var d=65535&(b.charCodeAt(0)|0),g=(a=45===d)?2147483648:2147483647;d=a||43===d?1:0;d>=(b.length|0)&&jc(b);for(var e=0;d!==c;){ic||(ic=new hc);var h=ic,m=65535&(b.charCodeAt(d)|0);if(256>m)var t=48<=m&&57>=m?-48+m|0:65<=m&&90>=m?-55+m|0:97<=m&&122>=m?-87+m|0:-1;else if(65313<=m&&65338>=
m)t=-65303+m|0;else if(65345<=m&&65370>=m)t=-65335+m|0;else{var Xb=gc(h);Ma||(Ma=new La);b:for(var M=Xb,xd=m,Mb=0,qc=M.d.length;;){if(Mb===qc){var Nb=-1-Mb|0;break b}var Ob=(Mb+qc|0)>>>1|0,yd=M.d[Ob];if(xd<yd)qc=Ob;else{if(G(H(),xd,yd)){Nb=Ob;break b}Mb=1+Ob|0}}M=0>Nb?-2-Nb|0:Nb;if(0>M)t=-1;else{var zd=m-gc(h).d[M]|0;t=9<zd?-1:zd}}var Ad=10>t?t:-1;e=10*e+Ad;(-1===Ad||e>g)&&jc(b);d=1+d|0}}catch(Xd){throw Xd;}this.Oa=a?-e|0:e|0;this.qb=new ld(od(),0,0)}md.prototype=new v;md.prototype.constructor=md;
md.prototype.$classData=y({Pc:0},"scala.collection.immutable.Vector$",{Pc:1,a:1,pc:1,aa:1,A:1,c:1});var nd;function tb(){nd||(nd=new md);return nd}function ia(a){a=+a;return Ca(Da(),a)}class kc extends Ec{constructor(a){super();P(this,a)}}kc.prototype.$classData=y({Eb:0},"java.lang.NumberFormatException",{Eb:1,Xa:1,t:1,x:1,y:1,a:1,c:1});function u(a){for(var b=0,c=1,d=-1+(a.length|0)|0;0<=d;)b=b+k(65535&(a.charCodeAt(d)|0),c)|0,c=k(31,c),d=-1+d|0;return b}function pd(){}pd.prototype=new v;
pd.prototype.constructor=pd;function qd(){}qd.prototype=pd.prototype;pd.prototype.ha=function(){return this.T()};pd.prototype.ga=function(a,b,c,d){return Xa(this,a,b,c,d)};function rd(a){this.H=0;this.hc=a;this.$=0;this.H=a.f()}rd.prototype=new Uc;rd.prototype.constructor=rd;f=rd.prototype;f.u=function(){return this.H};f.h=function(){return 0<this.H};f.i=function(){if(this.h()){var a=this.hc.s(this.$);this.$=1+this.$|0;this.H=-1+this.H|0;return a}return E().P.i()};
f.ia=function(a){0<a&&(this.$=this.$+a|0,a=this.H-a|0,this.H=0>a?0:a);return this};f.$classData=y({gc:0},"scala.collection.IndexedSeqView$IndexedSeqViewIterator",{gc:1,fb:1,a:1,Ja:1,B:1,C:1,c:1});
class fd extends U{constructor(a){super();this.ea=a;P(this,null)}ja(){return ja(this.ea)}Ua(){}Ea(){return"JavaScriptException"}ab(){return 1}bb(a){if(0===a)a=this.ea;else throw J(),new dd(""+a);return a}z(){Ic();var a=this.ab();if(0===a)a=u(this.Ea());else{var b=K(-889275714,u(this.Ea()));for(var c=0;c<a;){var d=this.bb(c);b=K(b,I(J(),d));c=1+c|0}a=L(b^a)}return a}w(a){if(this===a)return!0;if(a instanceof fd){var b=this.ea;a=a.ea;return G(H(),b,a)}return!1}}
fd.prototype.$classData=y({Uc:0},"scala.scalajs.js.JavaScriptException",{Uc:1,t:1,x:1,y:1,a:1,c:1,Tb:1,ma:1});function sd(){}sd.prototype=new qd;sd.prototype.constructor=sd;function td(){}td.prototype=sd.prototype;sd.prototype.j=function(){return this.T()+"(\x3cnot computed\x3e)"};function ud(a,b){return a===b?!0:b&&b.$classData&&b.$classData.q.ua&&b.Sa(a)?a.pa(b):!1}function vd(){}vd.prototype=new qd;vd.prototype.constructor=vd;function wd(){}f=wd.prototype=vd.prototype;f.Sa=function(){return!0};
f.w=function(a){return ud(this,a)};
f.z=function(){var a=Ic();if(this&&this.$classData&&this.$classData.q.gb)a:{var b=a.oa;a=this.f();switch(a){case 0:a=L(b^0);break a;case 1:a=b;b=this.s(0);a=L(K(a,I(J(),b))^1);break a;default:var c=this.s(0),d=I(J(),c);c=b=K(b,d);var g=this.s(1);g=I(J(),g);var e=g-d|0;for(d=2;d<a;){b=K(b,g);var h=this.s(d);h=I(J(),h);if(e!==(h-g|0)){b=K(b,h);for(d=1+d|0;d<a;)c=this.s(d),b=K(b,I(J(),c)),d=1+d|0;a=L(b^a);break a}g=h;d=1+d|0}a=L(K(K(c,e),g))}}else if(this instanceof Bd){for(a=a.oa;!this.e();)this.N();
a=L(a^0)}else a:if(b=a.oa,a=this.o(),a.h())if(c=a.i(),a.h()){d=a.i();e=I(J(),c);c=b=K(b,e);g=I(J(),d);e=g-e|0;for(d=2;a.h();){b=K(b,g);h=a.i();h=I(J(),h);if(e!==(h-g|0)){b=K(b,h);for(d=1+d|0;a.h();)c=a.i(),b=K(b,I(J(),c)),d=1+d|0;a=L(b^d);break a}g=h;d=1+d|0}a=L(K(K(c,e),g))}else a=L(K(b,I(J(),c))^1);else a=L(b^0);return a};f.j=function(){return Ua(this,this.ha()+"(",", ",")")};f.e=function(){return 0===this.Z(0)};f.pa=function(a){return Zc(this,a)};function Cd(){}Cd.prototype=new td;
Cd.prototype.constructor=Cd;function Dd(){}Dd.prototype=Cd.prototype;function Y(){this.wa=null}Y.prototype=new Dd;Y.prototype.constructor=Y;function Ed(){}Ed.prototype=Y.prototype;Y.prototype.s=function(a){return this.wa.s(a)};Y.prototype.f=function(){return this.wa.f()};Y.prototype.e=function(){return this.wa.e()};function Fd(a){this.wa=a}Fd.prototype=new Ed;Fd.prototype.constructor=Fd;f=Fd.prototype;f.o=function(){return new rd(this)};f.T=function(){return"IndexedSeqView"};
f.Z=function(a){var b=this.f();return b===a?0:b<a?-1:1};f.u=function(){return this.f()};f.$classData=y({fc:0},"scala.collection.IndexedSeqView$Id",{fc:1,od:1,kd:1,ld:1,qa:1,a:1,ra:1,B:1,ta:1,C:1,sa:1,qd:1,c:1,nd:1,va:1,md:1,hb:1});function Gd(){}Gd.prototype=new wd;Gd.prototype.constructor=Gd;function Hd(){}Hd.prototype=Gd.prototype;function Id(){}Id.prototype=new wd;Id.prototype.constructor=Id;function Jd(){}Jd.prototype=Id.prototype;
var Ld=function Kd(a,b){if(0>=b)return F().xa;F();return new V(new Q(((d,g)=>()=>{if(d.e())return Rc();F();var e=W(d).n(),h=Kd(W(d).g(),-1+g|0);return new S(e,h)})(a,b)))};
function Md(a,b,c,d,g){b.b=""+b.b+c;if(!a.r)b.b+="\x3cnot computed\x3e";else if(!a.e()){c=W(a).n();b.b=""+b.b+c;c=a;var e=W(a).g();if(c!==e&&(!e.r||W(c)!==W(e))&&(c=e,e.r&&!e.e()))for(e=W(e).g();c!==e&&e.r&&!e.e()&&W(c)!==W(e);){b.b=""+b.b+d;var h=W(c).n();b.b=""+b.b+h;c=W(c).g();e=W(e).g();e.r&&!e.e()&&(e=W(e).g())}if(!e.r||e.e()){for(;c!==e;)b.b=""+b.b+d,a=W(c).n(),b.b=""+b.b+a,c=W(c).g();c.r||(b.b=""+b.b+d,b.b+="\x3cnot computed\x3e")}else{h=a;for(a=0;;){var m=h,t=e;if(m!==t&&W(m)!==W(t))h=W(h).g(),
e=W(e).g(),a=1+a|0;else break}h=c;m=e;(h===m||W(h)===W(m))&&0<a&&(b.b=""+b.b+d,a=W(c).n(),b.b=""+b.b+a,c=W(c).g());for(;;)if(a=c,h=e,a!==h&&W(a)!==W(h))b.b=""+b.b+d,a=W(c).n(),b.b=""+b.b+a,c=W(c).g();else break;b.b=""+b.b+d;b.b+="\x3ccycle\x3e"}}b.b=""+b.b+g;return b}function V(a){this.nb=null;this.La=!1;this.mb=a;this.Ma=this.r=!1}V.prototype=new Hd;V.prototype.constructor=V;f=V.prototype;f.T=function(){return"LinearSeq"};f.f=function(){for(var a=this,b=0;!a.e();)b=1+b|0,a=a.U();return b};
f.Z=function(a){if(0>a)a=1;else a:for(var b=this,c=0;;){if(c===a){a=b.e()?0:1;break a}if(b.e()){a=-1;break a}c=1+c|0;b=b.U()}return a};f.s=function(a){return gd(this,a)};f.pa=function(a){return hd(this,a)};function W(a){if(!a.La&&!a.La){if(a.Ma)throw $b||($b=new Zb),a=new U,P(a,"self-referential LazyList or a derivation thereof has no more elements"),a instanceof fd?a.ea:a;a.Ma=!0;try{var b=Sc(a.mb)}finally{a.Ma=!1}a.r=!0;a.mb=null;a.nb=b;a.La=!0}return a.nb}f.e=function(){return W(this)===Rc()};
f.u=function(){return this.r&&this.e()?0:-1};f.n=function(){return W(this).n()};function bd(a){var b=a,c=a;for(b.e()||(b=W(b).g());c!==b&&!b.e();){b=W(b).g();if(b.e())break;b=W(b).g();if(b===c)break;c=W(c).g()}return a}f.o=function(){return this.r&&this.e()?E().P:new X(this)};f.ha=function(){return"LazyList"};function ec(){var a=Ac();return a.r&&a.e()?F().xa:Ld(a,8)}f.ga=function(a,b,c,d){bd(this);Md(this,a.v,b,c,d);return a};
f.j=function(){var a=new C;Wa(a);a.b="LazyList";return Md(this,a,"(",", ",")").b};f.Ta=function(a){return 0>=a?this:this.r&&this.e()?F().xa:cd(F(),this,a)};f.U=function(){return W(this).g()};f.$classData=y({xc:0},"scala.collection.immutable.LazyList",{xc:1,jb:1,Ia:1,qa:1,a:1,ra:1,B:1,ta:1,C:1,sa:1,ua:1,Ga:1,za:1,va:1,ma:1,ob:1,lb:1,pb:1,Fc:1,ib:1,mc:1,Gc:1,c:1});function Nd(){this.S=null}Nd.prototype=new Hd;Nd.prototype.constructor=Nd;function Od(){}f=Od.prototype=Nd.prototype;
f.Sa=function(a){return a&&a.$classData&&a.$classData.q.kb?this.f()===a.f():!0};f.pa=function(a){if(a&&a.$classData&&a.$classData.q.kb)if(this===a)var b=!0;else{var c=this.f();if(b=c===a.f()){var d=0,g=tb().Oa,e=tb().Oa;g=g<e?g:e;e=c>>31;var h=g>>>31|0|g>>31<<1;for(g=(e===h?(-2147483648^c)>(-2147483648^g<<1):e>h)?g:c;d<g&&b;)H(),Pd(d),b=G(0,void 0,Pd(d)),d=1+d|0;if(d<c&&b)for(c=this.o().ia(d),a=a.o().ia(d);b&&c.h();)b=G(H(),c.i(),a.i())}}else b=Zc(this,a);return b};f.T=function(){return"IndexedSeq"};
f.Z=function(a){var b=this.f();return b===a?0:b<a?-1:1};f.u=function(){return this.f()};f.f=function(){return this instanceof Qd?this.Ka:this.S.d.length};f.o=function(){return od()===this?tb().qb:new ld(this,this.f(),0)};f.ha=function(){return"Vector"};function Bd(){}Bd.prototype=new Hd;Bd.prototype.constructor=Bd;function Rd(){}f=Rd.prototype=Bd.prototype;f.T=function(){return"LinearSeq"};f.s=function(a){return gd(this,a)};f.pa=function(a){return hd(this,a)};f.e=function(){return this===ob()};
f.f=function(){for(var a=0;!this.e();)a=1+a|0,Sd();return a};f.Z=function(a){if(0>a)a=1;else a:for(;;){if(0===a){a=this.e()?0:1;break a}if(this.e()){a=-1;break a}Sd()}return a};f.ha=function(){return"List"};f.w=function(a){if(a instanceof Bd)a:for(;;){if(this===a){a=!0;break a}var b=this.e(),c=a.e();if(b||c)d=!1;else{H();this.N();var d=G(0,void 0,a.N())}if(d)Sd();else{a=b&&c;break a}}else a=ud(this,a);return a};f.Ta=function(a){a:for(var b=this;;){if(0>=a||b.e())break a;a=-1+a|0;b=b.U()}return b};
function Td(){this.S=null}Td.prototype=new Od;Td.prototype.constructor=Td;function Ud(){}Ud.prototype=Td.prototype;function Qd(){this.S=null;this.Ka=0}Qd.prototype=new Ud;Qd.prototype.constructor=Qd;function Vd(){}Vd.prototype=Qd.prototype;function Wd(){Yd=this;ob();ob()}Wd.prototype=new Rd;Wd.prototype.constructor=Wd;f=Wd.prototype;f.N=function(){throw new Oc("head of empty list");};function Sd(){throw new Pc("tail of empty list");}f.u=function(){return 0};f.o=function(){return E().P};f.Ea=function(){return"Nil"};
f.ab=function(){return 0};f.bb=function(a){J();throw new dd(""+a);};f.U=function(){Sd()};f.n=function(){this.N()};f.$classData=y({Kc:0},"scala.collection.immutable.Nil$",{Kc:1,td:1,jb:1,Ia:1,qa:1,a:1,ra:1,B:1,ta:1,C:1,sa:1,ua:1,Ga:1,za:1,va:1,ma:1,ob:1,lb:1,pb:1,Fc:1,ib:1,mc:1,Gc:1,pd:1,qc:1,oc:1,Oc:1,tc:1,c:1,Tb:1});var Yd;function ob(){Yd||(Yd=new Wd);return Yd}function Z(){this.S=null;this.Ka=0;var a=$a().rb;$a();this.Ka=0;this.S=a}Z.prototype=new Vd;Z.prototype.constructor=Z;
function Pd(a){throw new dd(a+" is out of bounds (empty vector)");}Z.prototype.w=function(a){return this===a||!(a instanceof Nd)&&ud(this,a)};Z.prototype.s=function(a){Pd(a)};Z.prototype.$classData=y({Qc:0},"scala.collection.immutable.Vector0$",{Qc:1,rd:1,vd:1,ud:1,jb:1,Ia:1,qa:1,a:1,ra:1,B:1,ta:1,C:1,sa:1,ua:1,Ga:1,za:1,va:1,ma:1,ob:1,lb:1,pb:1,kb:1,gb:1,hb:1,sd:1,Oc:1,qc:1,oc:1,tc:1,c:1});var Zd;function od(){Zd||(Zd=new Z);return Zd}function Va(){this.v=null}Va.prototype=new Jd;
Va.prototype.constructor=Va;f=Va.prototype;f.T=function(){return"IndexedSeq"};f.o=function(){var a=new Fd(this);return new rd(a)};f.Z=function(a){var b=this.v.f();return b===a?0:b<a?-1:1};f.f=function(){return this.v.f()};f.u=function(){return this.v.f()};f.j=function(){return this.v.b};f.e=function(){return 0===this.v.f()};f.s=function(a){return new l(65535&(this.v.b.charCodeAt(a)|0))};
f.$classData=y({Sc:0},"scala.collection.mutable.StringBuilder",{Sc:1,wd:1,Ia:1,qa:1,a:1,ra:1,B:1,ta:1,C:1,sa:1,ua:1,Ga:1,za:1,va:1,ma:1,Fd:1,Dd:1,Gd:1,zd:1,Aa:1,Ed:1,xd:1,Ad:1,yd:1,Bd:1,gb:1,hb:1,Cd:1,yb:1,c:1});ca=new n(0,0);za.sb=ca;mdoc_js_run2=function(a){B();N(O(),"pieChart",a,0)};mdoc_js_run4=function(a){B();N(O(),"wordcloud",a,50)};mdoc_js_run8=function(a){B();N(O(),"regression",a,25)};mdoc_js_run6=function(a){B();N(O(),"dotplot",a,0)};
mdoc_js_run3=function(a){B();N(O(),"pieChartLabelled",a,0)};mdoc_js_run1=function(a){B();N(O(),"unlballedBarChart",a,0)};mdoc_js_run5=function(a){B();N(O(),"lineChart",a,0)};mdoc_js_run7=function(a){B();N(O(),"scatterPlot",a,0)};mdoc_js_run0=function(a){B();N(O(),"labelledBarChart",a,0)};
}).call(this);
