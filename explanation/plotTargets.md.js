'use strict';var h,aa=require("vega-embed"),ba=Object.freeze({esVersion:6,assumingES6:!0,productionMode:!0,linkerVersion:"1.13.0",fileLevelThis:this}),ca;function da(a){for(var b in a)return b}function k(a){this.Ra=a}k.prototype.toString=function(){return String.fromCharCode(this.Ra)};var fa=function ea(a,b,c){var f=new a.va(b[c]);if(c<b.length-1){a=a.O;c+=1;for(var e=f.d,g=0;g<e.length;g++)e[g]=ea(a,b,c)}return f};
function ha(a){switch(typeof a){case "string":return l(ia);case "number":return ja(a)?a<<24>>24===a?l(ka):a<<16>>16===a?l(la):l(ma):na(a)?l(oa):l(pa);case "boolean":return l(qa);case "undefined":return l(ra);default:return null===a?a.yb():a instanceof m?l(sa):a instanceof k?l(ta):a&&a.$classData?l(a.$classData):null}}
function ua(a){switch(typeof a){case "string":return"java.lang.String";case "number":return ja(a)?a<<24>>24===a?"java.lang.Byte":a<<16>>16===a?"java.lang.Short":"java.lang.Integer":na(a)?"java.lang.Float":"java.lang.Double";case "boolean":return"java.lang.Boolean";case "undefined":return"java.lang.Void";default:return null===a?a.yb():a instanceof m?"java.lang.Long":a instanceof k?"java.lang.Character":a&&a.$classData?a.$classData.name:null.F.name}}
function va(a){switch(typeof a){case "string":return q(a);case "number":return wa(a);case "boolean":return a?1231:1237;case "undefined":return 0;default:return a&&a.$classData||null===a?a.z():a instanceof m?a.E^a.D:a instanceof k?null===a?0:a.Ra:r.prototype.z.call(a)}}var xa=0,ya=new WeakMap;
function za(a){switch(typeof a){case "string":return q(a);case "number":return wa(a);case "bigint":var b=0;for(a<BigInt(0)&&(a=~a);a!==BigInt(0);)b^=Number(BigInt.asIntN(32,a)),a>>=BigInt(32);return b;case "boolean":return a?1231:1237;case "undefined":return 0;case "symbol":return a=a.description,void 0===a?0:q(a);default:if(null===a)return 0;b=ya.get(a);void 0===b&&(xa=b=xa+1|0,ya.set(a,b));return b}}function ja(a){return"number"===typeof a&&(a|0)===a&&1/a!==1/-0}
function na(a){return"number"===typeof a&&(a!==a||Math.fround(a)===a)}function r(){}r.prototype.constructor=r;function t(){}t.prototype=r.prototype;r.prototype.z=function(){return za(this)};r.prototype.g=function(){var a=this.z();return ua(this)+"@"+(+(a>>>0)).toString(16)};r.prototype.toString=function(){return this.g()};function u(a){if("number"===typeof a){this.d=Array(a);for(var b=0;b<a;b++)this.d[b]=null}else this.d=a}u.prototype=new t;u.prototype.constructor=u;function Aa(){}Aa.prototype=u.prototype;
function Ba(a){if("number"===typeof a){this.d=Array(a);for(var b=0;b<a;b++)this.d[b]=!1}else this.d=a}Ba.prototype=new t;Ba.prototype.constructor=Ba;function Ca(a){this.d="number"===typeof a?new Uint16Array(a):a}Ca.prototype=new t;Ca.prototype.constructor=Ca;function Da(a){this.d="number"===typeof a?new Int8Array(a):a}Da.prototype=new t;Da.prototype.constructor=Da;function Ea(a){this.d="number"===typeof a?new Int16Array(a):a}Ea.prototype=new t;Ea.prototype.constructor=Ea;
function Fa(a){this.d="number"===typeof a?new Int32Array(a):a}Fa.prototype=new t;Fa.prototype.constructor=Fa;function Ga(a){if("number"===typeof a){this.d=Array(a);for(var b=0;b<a;b++)this.d[b]=ca}else this.d=a}Ga.prototype=new t;Ga.prototype.constructor=Ga;function Ha(a){this.d="number"===typeof a?new Float32Array(a):a}Ha.prototype=new t;Ha.prototype.constructor=Ha;function Ia(a){this.d="number"===typeof a?new Float64Array(a):a}Ia.prototype=new t;Ia.prototype.constructor=Ia;
function v(){this.va=void 0;this.M=this.O=this.r=null;this.N=0;this.sb=null;this.y="";this.A=this.L=this.ua=void 0;this.name="";this.isArrayClass=this.isInterface=this.isPrimitive=!1;this.isInstance=void 0}function w(a,b,c,d){var f=new v;f.r={};f.sb=a;f.y=b;f.A=e=>e===f;f.name=c;f.isPrimitive=!0;f.isInstance=()=>!1;void 0!==d&&(f.L=Ja(f,d));return f}
function x(a,b,c,d){var f=new v,e=da(a);f.r=c;f.y="L"+b+";";f.A=g=>!!g.r[e];f.name=b;f.isInterface=!1;f.isInstance=d||(g=>!!(g&&g.$classData&&g.$classData.r[e]));return f}function Ja(a,b,c){var d=new v;b.prototype.$classData=d;var f="["+a.y;d.va=b;d.r={a:1,xa:1,c:1};d.O=a;d.M=a;d.N=1;d.y=f;d.name=f;d.isArrayClass=!0;d.A=c||(e=>d===e);d.isInstance=e=>e instanceof b;return d}
function Ka(a){function b(n){if("number"===typeof n){this.d=Array(n);for(var p=0;p<n;p++)this.d[p]=null}else this.d=n}var c=new v;b.prototype=new Aa;b.prototype.constructor=b;var d=a.M||a,f=a.N+1;b.prototype.$classData=c;var e="["+a.y;c.va=b;c.r={a:1,xa:1,c:1};c.O=a;c.M=d;c.N=f;c.y=e;c.name=e;c.isArrayClass=!0;var g=n=>{var p=n.N;return p===f?d.A(n.M):p>f&&d===y};c.A=g;c.isInstance=n=>{n=n&&n.$classData;return!!n&&(n===c||g(n))};return c}function l(a){a.ua||(a.ua=new z(a));return a.ua}
v.prototype.isAssignableFrom=function(a){return this===a||this.A(a)};v.prototype.checkCast=function(){};v.prototype.getSuperclass=function(){return this.bc?l(this.bc):null};v.prototype.getComponentType=function(){return this.O?l(this.O):null};v.prototype.newArrayOfThisClass=function(a){for(var b=this,c=0;c<a.length;c++)b.L||(b.L=Ka(b)),b=b.L;return fa(b,a,0)};var y=new v;y.r={a:1};y.y="Ljava.lang.Object;";y.A=a=>!a.isPrimitive;y.name="java.lang.Object";y.isInstance=a=>null!==a;
y.L=Ja(y,u,a=>{var b=a.N;return 1===b?!a.M.isPrimitive:1<b});r.prototype.$classData=y;w(void 0,"V","void",void 0);w(!1,"Z","boolean",Ba);w(0,"C","char",Ca);w(0,"B","byte",Da);w(0,"S","short",Ea);w(0,"I","int",Fa);var La=w(null,"J","long",Ga);w(0,"F","float",Ha);w(0,"D","double",Ia);function z(a){this.F=a}z.prototype=new t;z.prototype.constructor=z;z.prototype.g=function(){return(this.F.isInterface?"interface ":this.F.isPrimitive?"":"class ")+this.F.name};
z.prototype.$classData=x({Fb:0},"java.lang.Class",{Fb:1,a:1});function Ma(){this.Va=this.da=this.P=null;Na=this;this.P=new ArrayBuffer(8);this.da=new Int32Array(this.P,0,2);new Float32Array(this.P,0,2);this.Va=new Float64Array(this.P,0,1);this.da[0]=16909060;new Int8Array(this.P,0,8)}Ma.prototype=new t;Ma.prototype.constructor=Ma;function Oa(a,b){var c=b|0;if(c===b&&-Infinity!==1/b)return c;a.Va[0]=b;return(a.da[0]|0)^(a.da[1]|0)}
Ma.prototype.$classData=x({Ib:0},"java.lang.FloatingPointBits$",{Ib:1,a:1});var Na;function Pa(){Na||(Na=new Ma);return Na}function Qa(){this.Xa=null;Ra=this;this.Xa=new Sa(!1)}Qa.prototype=new t;Qa.prototype.constructor=Qa;Qa.prototype.$classData=x({Tb:0},"java.lang.System$Streams$",{Tb:1,a:1});var Ra;function Ta(){Ra||(Ra=new Qa);return Ra}
function Ua(){this.Ya=this.ya=null;Va=this;var a={"java.version":"1.8","java.vm.specification.version":"1.8","java.vm.specification.vendor":"Oracle Corporation","java.vm.specification.name":"Java Virtual Machine Specification","java.vm.name":"Scala.js"};a["java.vm.version"]=ba.linkerVersion;a["java.specification.version"]="1.8";a["java.specification.vendor"]="Oracle Corporation";a["java.specification.name"]="Java Platform API Specification";a["file.separator"]="/";a["path.separator"]=":";a["line.separator"]=
"\n";this.ya=a;this.Ya=null}Ua.prototype=new t;Ua.prototype.constructor=Ua;function Wa(a,b,c){return null!==a.ya?(a=a.ya,Xa||(Xa=new Ya),Xa.$a.call(a,b)?a[b]:c):Wa(a.Ya,b,c)}Ua.prototype.$classData=x({Ub:0},"java.lang.System$SystemProperties$",{Ub:1,a:1});var Va;function Ya(){this.$a=null;Xa=this;this.$a=Object.prototype.hasOwnProperty}Ya.prototype=new t;Ya.prototype.constructor=Ya;Ya.prototype.$classData=x({Wb:0},"java.lang.Utils$Cache$",{Wb:1,a:1});
var Xa,ra=x({Xb:0},"java.lang.Void",{Xb:1,a:1},a=>void 0===a);function Za(){}Za.prototype=new t;Za.prototype.constructor=Za;Za.prototype.$classData=x({Yb:0},"java.util.Arrays$",{Yb:1,a:1});var $a;function m(a,b){this.E=a;this.D=b}m.prototype=new t;m.prototype.constructor=m;m.prototype.z=function(){return this.E^this.D};m.prototype.g=function(){ab();var a=this.E,b=this.D;return b===a>>31?""+a:0>b?"-"+bb(-a|0,0!==a?~b:-b|0):bb(a,b)};
m.prototype.$classData=x({vb:0},"org.scalajs.linker.runtime.RuntimeLong",{vb:1,a:1});
function bb(a,b){if(0===(-2097152&b))b=""+(4294967296*b+ +(a>>>0));else{var c=(32+(Math.clz32(1E9)|0)|0)-(0!==b?Math.clz32(b)|0:32+(Math.clz32(a)|0)|0)|0,d=c,f=0===(32&d)?1E9<<d:0;d=0===(32&d)?5E8>>>(31-d|0)|0|0<<d:1E9<<d;var e=a,g=b;for(a=b=0;0<=c&&0!==(-2097152&g);){var n=e,p=g,C=f,U=d;if(p===U?(-2147483648^n)>=(-2147483648^C):(-2147483648^p)>=(-2147483648^U))n=g,p=d,g=e-f|0,n=(-2147483648^g)>(-2147483648^e)?-1+(n-p|0)|0:n-p|0,e=g,g=n,32>c?b|=1<<c:a|=1<<c;c=-1+c|0;n=d>>>1|0;f=f>>>1|0|d<<31;d=n}c=
g;if(0===c?-1147483648<=(-2147483648^e):-2147483648<=(-2147483648^c))c=4294967296*g+ +(e>>>0),e=c/1E9,f=e/4294967296|0,d=b,b=e=d+(e|0)|0,a=(-2147483648^e)<(-2147483648^d)?1+(a+f|0)|0:a+f|0,e=c%1E9|0;c=""+e;b=""+(4294967296*a+ +(b>>>0))+"000000000".substring(c.length)+c}return b}function cb(){this.Z=0}cb.prototype=new t;cb.prototype.constructor=cb;cb.prototype.$classData=x({wb:0},"org.scalajs.linker.runtime.RuntimeLong$",{wb:1,a:1});var db;function ab(){db||(db=new cb);return db}
function eb(a,b,c,d){if(a.e())a=""+b+d;else{var f=a.$,e=new fb;e.q=gb(new A);a=f.call(a,e,b,c,d).q.b}return a}function hb(a,b,c,d,f){var e=b.q;0!==c.length&&(e.b=""+e.b+c);a=a.o();if(a.l())for(c=a.i(),e.b=""+e.b+c;a.l();)e.b=""+e.b+d,c=a.i(),e.b=""+e.b+c;0!==f.length&&(e.b=""+e.b+f);return b}function ib(){jb=this}ib.prototype=new t;ib.prototype.constructor=ib;ib.prototype.$classData=x({vc:0},"scala.collection.StringOps$",{vc:1,a:1});var jb;function kb(){this.qb=null;lb=this;this.qb=new u(0)}
kb.prototype=new t;kb.prototype.constructor=kb;kb.prototype.$classData=x({Rc:0},"scala.collection.immutable.VectorStatics$",{Rc:1,a:1});var lb;function mb(){lb||(lb=new kb);return lb}function nb(){this.cb=null;ob=this;pb||(pb=new B);pb||(pb=new B);qb||(qb=new rb);ub||(ub=new vb);D();wb();this.cb=E();F();xb()}nb.prototype=new t;nb.prototype.constructor=nb;nb.prototype.$classData=x({ec:0},"scala.package$",{ec:1,a:1});var ob;function yb(){}yb.prototype=new t;yb.prototype.constructor=yb;
function G(a,b){if(null===b)return 0;if("number"===typeof b){a=+b;b=2147483647<a?2147483647:-2147483648>a?-2147483648:a|0;if(b===a)a=b;else{b=ab();if(-0x7fffffffffffffff>a){b.Z=-2147483648;var c=0}else if(0x7fffffffffffffff<=a)b.Z=2147483647,c=-1;else{c=a|0;var d=a/4294967296|0;b.Z=0>a&&0!==c?-1+d|0:d}b=b.Z;ab();a=(0>b?-(4294967296*+((0!==c?~b:-b|0)>>>0)+ +((-c|0)>>>0)):4294967296*b+ +(c>>>0))===a?c^b:Oa(Pa(),a)}return a}return b instanceof m?(a=null===b?ca:b,b=new m(a.E,a.D),a=b.E,b=b.D,b===a>>31?
a:a^b):va(b)}yb.prototype.$classData=x({Wc:0},"scala.runtime.Statics$",{Wc:1,a:1});var zb;function H(){zb||(zb=new yb);return zb}function I(a){this.db=a}I.prototype=new t;I.prototype.constructor=I;I.prototype.g=function(){return"DynamicVariable("+this.db+")"};I.prototype.$classData=x({fc:0},"scala.util.DynamicVariable",{fc:1,a:1});function Ab(){}Ab.prototype=new t;Ab.prototype.constructor=Ab;function Bb(){}Bb.prototype=Ab.prototype;
function J(a,b){a=Cb(a,b);return-430675100+Math.imul(5,a<<13|a>>>19|0)|0}function Cb(a,b){b=Math.imul(-862048943,b);b=Math.imul(461845907,b<<15|b>>>17|0);return a^b}function K(a){a=Math.imul(-2048144789,a^(a>>>16|0));a=Math.imul(-1028477387,a^(a>>>13|0));return a^(a>>>16|0)}function Db(){}Db.prototype=new t;Db.prototype.constructor=Db;Db.prototype.$classData=x({tb:0},"viz.doc.showJsDocs$",{tb:1,a:1});var Eb;
function Fb(a){0===(32&a.ca)<<24>>24&&0===(32&a.ca)<<24>>24&&(a.Ua=new Fa(new Int32Array([1632,1776,1984,2406,2534,2662,2790,2918,3046,3174,3302,3430,3664,3792,3872,4160,4240,6112,6160,6470,6608,6784,6800,6992,7088,7232,7248,42528,43216,43264,43472,43600,44016,65296,66720,69734,69872,69942,70096,71360,120782,120792,120802,120812,120822])),a.ca=(32|a.ca)<<24>>24);return a.Ua}function Gb(){this.Ua=null;this.ca=0}Gb.prototype=new t;Gb.prototype.constructor=Gb;
Gb.prototype.$classData=x({Eb:0},"java.lang.Character$",{Eb:1,a:1,c:1});var Hb;function Ib(a){throw new Jb('For input string: "'+a+'"');}function Kb(){}Kb.prototype=new t;Kb.prototype.constructor=Kb;Kb.prototype.$classData=x({Lb:0},"java.lang.Integer$",{Lb:1,a:1,c:1});var Lb;function L(a,b){a.Za=b;"[object Error]"!==Object.prototype.toString.call(a)&&(void 0===Error.captureStackTrace?Error():Error.captureStackTrace(a))}
class Mb extends Error{constructor(){super();this.Za=null}wa(){return this.Za}g(){var a=ua(this),b=this.wa();return null===b?a:a+": "+b}z(){return r.prototype.z.call(this)}get message(){var a=this.wa();return null===a?"":a}get name(){return ua(this)}toString(){return this.g()}}function Nb(){this.Aa=this.za=0}Nb.prototype=new t;Nb.prototype.constructor=Nb;Nb.prototype.$classData=x({$b:0},"java.util.Random",{$b:1,a:1,c:1});
function Ob(){var a=4294967296*+Math.random();a=+Math.floor(a)-2147483648;return 2147483647<a?2147483647:-2147483648>a?-2147483648:a|0}function Pb(){}Pb.prototype=new t;Pb.prototype.constructor=Pb;Pb.prototype.$classData=x({ac:0},"java.util.Random$",{ac:1,a:1,c:1});var Qb;function Rb(){this.ab=null;Sb=this;this.ab=new I(Ta().Xa);Ta()}Rb.prototype=new t;Rb.prototype.constructor=Rb;Rb.prototype.$classData=x({cc:0},"scala.Console$",{cc:1,a:1,fd:1});var Sb;function Tb(){}Tb.prototype=new t;
Tb.prototype.constructor=Tb;function Ub(){}Ub.prototype=Tb.prototype;Tb.prototype.g=function(){return"\x3cfunction0\x3e"};function Vb(a){this.Pa=a}Vb.prototype=new t;Vb.prototype.constructor=Vb;Vb.prototype.g=function(){return""+this.Pa};Vb.prototype.$classData=x({Uc:0},"scala.runtime.IntRef",{Uc:1,a:1,c:1});function Wb(a){this.Qa=a}Wb.prototype=new t;Wb.prototype.constructor=Wb;Wb.prototype.g=function(){return""+this.Qa};Wb.prototype.$classData=x({Vc:0},"scala.runtime.ObjectRef",{Vc:1,a:1,c:1});
function Xb(){this.Ea=null}Xb.prototype=new t;Xb.prototype.constructor=Xb;function Yb(){}Yb.prototype=Xb.prototype;function Zb(){$b||($b=new ac);var a=$b;return bc(F(),new M(()=>{var b;a:for(b=a.Ea;;){var c=b;var d=c.Aa,f=15525485*d+11;d=16777215&((f/16777216|0)+(16777215&(1502*d+15525485*c.za|0))|0);f=16777215&(f|0);c.za=d;c.Aa=f;c=(d<<8|f>>16)>>>1|0;f=c%62|0;if(!(0>((c-f|0)+61|0)))break a}b="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charCodeAt(f);return new k(b)}))}
function cc(){this.eb=this.ha=0;dc=this;this.ha=q("Seq");this.eb=q("Map");q("Set");ob||(ob=new nb);for(var a=this.eb,b=0,c=0,d=0,f=1,e=ob.cb.o();e.l();){var g=e.i();g=G(H(),g);b=b+g|0;c^=g;f=Math.imul(f,1|g);d=1+d|0}a=J(a,b);a=J(a,c);a=Cb(a,f);K(a^d)}cc.prototype=new Bb;cc.prototype.constructor=cc;cc.prototype.$classData=x({hc:0},"scala.util.hashing.MurmurHash3$",{hc:1,hd:1,a:1});var dc;function ec(){fc=this}ec.prototype=new t;ec.prototype.constructor=ec;
ec.prototype.$classData=x({ub:0},"viz.vega.facades.EmbedOptions$",{ub:1,a:1,cd:1});var fc;class gc extends Mb{}function hc(){}hc.prototype=new t;hc.prototype.constructor=hc;function ic(){}ic.prototype=hc.prototype;function jc(){this.G=null;kc=this;this.G=new N}jc.prototype=new t;jc.prototype.constructor=jc;jc.prototype.$classData=x({nc:0},"scala.collection.Iterator$",{nc:1,a:1,B:1,c:1});var kc;function D(){kc||(kc=new jc);return kc}function O(a,b){this.Ec=a;this.Fc=b}O.prototype=new t;
O.prototype.constructor=O;O.prototype.j=function(){return this.Ec};O.prototype.f=function(){return this.Fc};O.prototype.$classData=x({Dc:0},"scala.collection.immutable.LazyList$State$Cons",{Dc:1,a:1,Cc:1,c:1});function P(){}P.prototype=new t;P.prototype.constructor=P;P.prototype.ba=function(){throw new lc("head of empty lazy list");};P.prototype.f=function(){throw new mc("tail of empty lazy list");};P.prototype.j=function(){this.ba()};
P.prototype.$classData=x({Gc:0},"scala.collection.immutable.LazyList$State$Empty$",{Gc:1,a:1,Cc:1,c:1});var nc;function oc(){nc||(nc=new P);return nc}function M(a){this.rb=a}M.prototype=new Ub;M.prototype.constructor=M;M.prototype.$classData=x({Tc:0},"scala.scalajs.runtime.AnonFunction0",{Tc:1,Hd:1,a:1,Xc:1});function ac(){this.Ea=null;var a=new Nb;Qb||(Qb=new Pb);var b=Ob();var c=Ob();b=new m(c,b);c=-554899859^b.E;a.za=c>>>24|0|(65535&(5^b.D))<<8;a.Aa=16777215&c;this.Ea=a}ac.prototype=new Yb;
ac.prototype.constructor=ac;ac.prototype.$classData=x({gc:0},"scala.util.Random$",{gc:1,gd:1,a:1,c:1});var $b;function pc(){}pc.prototype=new t;pc.prototype.constructor=pc;function qc(){}qc.prototype=pc.prototype;var qa=x({Bb:0},"java.lang.Boolean",{Bb:1,a:1,c:1,s:1,v:1},a=>"boolean"===typeof a),ta=x({Db:0},"java.lang.Character",{Db:1,a:1,c:1,s:1,v:1},a=>a instanceof k);class Q extends gc{}Q.prototype.$classData=x({p:0},"java.lang.RuntimeException",{p:1,t:1,u:1,a:1,c:1});
function gb(a){a.b="";return a}function A(){this.b=null}A.prototype=new t;A.prototype.constructor=A;A.prototype.g=function(){return this.b};A.prototype.h=function(){return this.b.length};A.prototype.$classData=x({Sb:0},"java.lang.StringBuilder",{Sb:1,a:1,Ta:1,zb:1,c:1});function R(){}R.prototype=new t;R.prototype.constructor=R;function rc(){}rc.prototype=R.prototype;R.prototype.o=function(){return this};R.prototype.e=function(){return!this.l()};R.prototype.g=function(){return"\x3citerator\x3e"};
R.prototype.$=function(a,b,c,d){return hb(this,a,b,c,d)};function B(){sc||(sc=new tc)}B.prototype=new ic;B.prototype.constructor=B;B.prototype.$classData=x({lc:0},"scala.collection.Iterable$",{lc:1,mc:1,a:1,B:1,c:1});var pb;function uc(){}uc.prototype=new t;uc.prototype.constructor=uc;function vc(){}vc.prototype=uc.prototype;function tc(){wb()}tc.prototype=new ic;tc.prototype.constructor=tc;tc.prototype.$classData=x({yc:0},"scala.collection.immutable.Iterable$",{yc:1,mc:1,a:1,B:1,c:1});var sc;
function wc(){this.pa=null;xc=this;this.pa=yc(new S(new M(()=>oc())))}wc.prototype=new t;wc.prototype.constructor=wc;function zc(a,b,c){var d=new Wb(b),f=new Vb(c);return new S(new M(()=>{for(var e=d.Qa,g=f.Pa;0<g&&!e.e();)e=T(e).f(),d.Qa=e,g=-1+g|0,f.Pa=g;return T(e)}))}function bc(a,b){return new S(new M(()=>{F();var c=(0,b.rb)(),d=bc(F(),b);return new O(c,d)}))}wc.prototype.$classData=x({Ac:0},"scala.collection.immutable.LazyList$",{Ac:1,a:1,ma:1,B:1,c:1});var xc;
function F(){xc||(xc=new wc);return xc}function Ac(){}Ac.prototype=new qc;Ac.prototype.constructor=Ac;function Bc(){}Bc.prototype=Ac.prototype;x({Ab:0},"java.lang.ArithmeticException",{Ab:1,p:1,t:1,u:1,a:1,c:1});var ka=x({Cb:0},"java.lang.Byte",{Cb:1,Q:1,a:1,c:1,s:1,v:1},a=>"number"===typeof a&&a<<24>>24===a&&1/a!==1/-0);class Cc extends Q{}Cc.prototype.$classData=x({Wa:0},"java.lang.IllegalArgumentException",{Wa:1,p:1,t:1,u:1,a:1,c:1});class Dc extends Q{constructor(a){super();L(this,a)}}
Dc.prototype.$classData=x({Jb:0},"java.lang.IndexOutOfBoundsException",{Jb:1,p:1,t:1,u:1,a:1,c:1});x({Pb:0},"java.lang.NullPointerException",{Pb:1,p:1,t:1,u:1,a:1,c:1});var la=x({Rb:0},"java.lang.Short",{Rb:1,Q:1,a:1,c:1,s:1,v:1},a=>"number"===typeof a&&a<<16>>16===a&&1/a!==1/-0);class mc extends Q{constructor(a){super();L(this,a)}}mc.prototype.$classData=x({Vb:0},"java.lang.UnsupportedOperationException",{Vb:1,p:1,t:1,u:1,a:1,c:1});class lc extends Q{constructor(a){super();L(this,a)}}
lc.prototype.$classData=x({Zb:0},"java.util.NoSuchElementException",{Zb:1,p:1,t:1,u:1,a:1,c:1});class Ec extends Q{constructor(a){super();this.bb=null;this.Ca=!1;this.ga=a;L(this,null)}wa(){if(!this.Ca&&!this.Ca){if(null===this.ga)var a="null";else try{var b=this.ga;a=(void 0===b?"undefined":b.toString())+" (of class "+ha(this.ga).F.name+")"}catch(c){a="an instance of class "+ha(this.ga).F.name}this.bb=a;this.Ca=!0}return this.bb}}
Ec.prototype.$classData=x({dc:0},"scala.MatchError",{dc:1,p:1,t:1,u:1,a:1,c:1});function N(){}N.prototype=new rc;N.prototype.constructor=N;N.prototype.l=function(){return!1};N.prototype.i=function(){throw new lc("next on empty iterator");};N.prototype.$classData=x({oc:0},"scala.collection.Iterator$$anon$19",{oc:1,fb:1,a:1,Ha:1,w:1,x:1});function Fc(a,b){if(0>b)throw new Dc(""+b);a=a.Sa(b);if(a.e())throw new Dc(""+b);return a.j()}function vb(){xb()}vb.prototype=new vc;vb.prototype.constructor=vb;
vb.prototype.$classData=x({xc:0},"scala.collection.immutable.IndexedSeq$",{xc:1,rc:1,a:1,ma:1,B:1,c:1});var ub;function V(a){this.T=a}V.prototype=new rc;V.prototype.constructor=V;V.prototype.l=function(){return!this.T.e()};V.prototype.i=function(){if(this.T.e())return D().G.i();var a=T(this.T).j();this.T=T(this.T).f();return a};V.prototype.$classData=x({Bc:0},"scala.collection.immutable.LazyList$LazyIterator",{Bc:1,fb:1,a:1,Ha:1,w:1,x:1});function Gc(){Lc=this;E();E()}Gc.prototype=new t;
Gc.prototype.constructor=Gc;Gc.prototype.$classData=x({Jc:0},"scala.collection.immutable.List$",{Jc:1,a:1,tc:1,ma:1,B:1,c:1});var Lc;function wb(){Lc||(Lc=new Gc)}function Mc(a,b,c){this.mb=this.qa=this.W=this.V=this.U=null;this.ra=b;this.Lc=c;this.H=a.J;this.Ma=this.H.d.length;this.Na=this.n=0;this.C=this.ra;this.Y=0;this.I=1;this.Oa=0;this.X=this.Ma}Mc.prototype=new t;Mc.prototype.constructor=Mc;h=Mc.prototype;h.o=function(){return this};h.e=function(){return this.C<=this.n};h.g=function(){return"\x3citerator\x3e"};
h.$=function(a,b,c,d){return hb(this,a,b,c,d)};h.l=function(){return this.C>this.n};
h.i=function(){if(this.n===this.Ma){var a=(this.n-this.C|0)+this.ra|0;if(a===this.X){this.C<=this.n&&D().G.i();this.Y=1+this.Y|0;for(var b=null;0===b.d.length;)this.Y=1+this.Y|0,b=null;this.Oa=this.X;var c=this.Lc/2|0,d=this.Y-c|0;c=this.I=(1+c|0)-(0>d?-d|0:d)|0;switch(c){case 1:this.H=b;break;case 2:this.U=b;break;case 3:this.V=b;break;case 4:this.W=b;break;case 5:this.qa=b;break;case 6:this.mb=b;break;default:throw new Ec(c);}this.X=this.Oa+Math.imul(b.d.length,1<<Math.imul(5,-1+this.I|0))|0;this.X>
this.ra&&(this.X=this.ra);1<this.I&&(this.Na=-1+(1<<Math.imul(5,this.I))|0)}1<this.I&&(a=a-this.Oa|0,b=this.Na^a,1024>b?this.H=this.U.d[31&(a>>>5|0)]:(32768>b?this.U=this.V.d[31&(a>>>10|0)]:(1048576>b?this.V=this.W.d[31&(a>>>15|0)]:(33554432>b?this.W=this.qa.d[31&(a>>>20|0)]:(this.qa=this.mb.d[a>>>25|0],this.W=this.qa.d[0]),this.V=this.W.d[0]),this.U=this.V.d[0]),this.H=this.U.d[0]),this.Na=a);this.C=this.C-this.n|0;a=this.H.d.length;b=this.C;this.Ma=a<b?a:b;this.n=0}a=this.H.d[this.n];this.n=1+this.n|
0;return a};h.$classData=x({Kc:0},"scala.collection.immutable.NewVectorIterator",{Kc:1,a:1,Ha:1,w:1,x:1,xa:1});function rb(){wb()}rb.prototype=new vc;rb.prototype.constructor=rb;rb.prototype.$classData=x({Nc:0},"scala.collection.immutable.Seq$",{Nc:1,rc:1,a:1,ma:1,B:1,c:1});var qb;
function Nc(){this.pb=null;Oc=this;try{jb||(jb=new ib);var a=Wa;Va||(Va=new Ua);var b=a(Va,"scala.collection.immutable.Vector.defaultApplyPreferredMaxLength","250");Lb||(Lb=new Kb);var c=null===b?0:b.length;0===c&&Ib(b);var d=b.charCodeAt(0),f=45===d;a=f?2147483648:2147483647;d=f||43===d?1:0;d>=b.length&&Ib(b);for(f=0;d!==c;){Hb||(Hb=new Gb);var e=Hb,g=b.charCodeAt(d);if(256>g)var n=48<=g&&57>=g?-48+g|0:65<=g&&90>=g?-55+g|0:97<=g&&122>=g?-87+g|0:-1;else if(65313<=g&&65338>=g)n=-65303+g|0;else if(65345<=
g&&65370>=g)n=-65335+g|0;else{$a||($a=new Za);b:for(var p=Fb(e),C=0,U=p.d.length;;){if(C===U){var sb=-1-C|0;break b}var tb=(C+U|0)>>>1|0,Hc=p.d[tb],Ic=g===Hc?0:g<Hc?-1:1;if(0>Ic)U=tb;else{if(0===Ic){sb=tb;break b}C=1+tb|0}}C=0>sb?-2-sb|0:sb;if(0>C)n=-1;else{var Jc=g-Fb(e).d[C]|0;n=9<Jc?-1:Jc}}var Kc=10>n?n:-1;f=10*f+Kc;(-1===Kc||f>a)&&Ib(b);d=1+d|0}}catch(rd){throw rd;}this.pb=new Mc(Pc(),0,0)}Nc.prototype=new t;Nc.prototype.constructor=Nc;
Nc.prototype.$classData=x({Pc:0},"scala.collection.immutable.Vector$",{Pc:1,a:1,tc:1,ma:1,B:1,c:1});var Oc;function xb(){Oc||(Oc=new Nc);return Oc}function wa(a){return Oa(Pa(),a)}var pa=x({Gb:0},"java.lang.Double",{Gb:1,Q:1,a:1,c:1,s:1,v:1,fa:1},a=>"number"===typeof a),oa=x({Hb:0},"java.lang.Float",{Hb:1,Q:1,a:1,c:1,s:1,v:1,fa:1},a=>na(a)),ma=x({Kb:0},"java.lang.Integer",{Kb:1,Q:1,a:1,c:1,s:1,v:1,fa:1},a=>ja(a)),sa=x({Ob:0},"java.lang.Long",{Ob:1,Q:1,a:1,c:1,s:1,v:1,fa:1},a=>a instanceof m);
class Jb extends Cc{constructor(a){super();L(this,a)}}Jb.prototype.$classData=x({Qb:0},"java.lang.NumberFormatException",{Qb:1,Wa:1,p:1,t:1,u:1,a:1,c:1});function q(a){for(var b=0,c=1,d=-1+a.length|0;0<=d;)b=b+Math.imul(a.charCodeAt(d),c)|0,c=Math.imul(31,c),d=-1+d|0;return b}var ia=x({xb:0},"java.lang.String",{xb:1,a:1,c:1,s:1,Ta:1,v:1,fa:1},a=>"string"===typeof a);function Qc(){}Qc.prototype=new t;Qc.prototype.constructor=Qc;function Rc(){}Rc.prototype=Qc.prototype;Qc.prototype.aa=function(){return this.K()};
Qc.prototype.$=function(a,b,c,d){return hb(this,a,b,c,d)};function W(a){this.S=0;this.kc=a;this.Ga=0;this.S=a.h()}W.prototype=new rc;W.prototype.constructor=W;W.prototype.l=function(){return 0<this.S};W.prototype.i=function(){if(0<this.S){var a=this.kc.k(this.Ga);this.Ga=1+this.Ga|0;this.S=-1+this.S|0;return a}return D().G.i()};W.prototype.$classData=x({jc:0},"scala.collection.IndexedSeqView$IndexedSeqViewIterator",{jc:1,fb:1,a:1,Ha:1,w:1,x:1,c:1});function Sc(){}Sc.prototype=new Bc;
Sc.prototype.constructor=Sc;function Tc(){}Tc.prototype=Sc.prototype;function Sa(a){this.Nb=a;this.ea=""}Sa.prototype=new Tc;Sa.prototype.constructor=Sa;Sa.prototype.$classData=x({Mb:0},"java.lang.JSConsoleBasedPrintStream",{Mb:1,bd:1,Zc:1,ad:1,a:1,Yc:1,dd:1,$c:1,zb:1});function Uc(){}Uc.prototype=new Rc;Uc.prototype.constructor=Uc;function Vc(){}Vc.prototype=Uc.prototype;Uc.prototype.g=function(){return this.K()+"(\x3cnot computed\x3e)"};function X(){}X.prototype=new Rc;X.prototype.constructor=X;
function Wc(){}Wc.prototype=X.prototype;
X.prototype.z=function(){dc||(dc=new cc);var a=dc;if(this&&this.$classData&&this.$classData.r.gb)a:{var b=a.ha;a=this.h();switch(a){case 0:a=K(b^0);break a;case 1:a=b;b=this.k(0);a=K(J(a,G(H(),b))^1);break a;default:var c=this.k(0),d=G(H(),c);c=b=J(b,d);var f=this.k(1);f=G(H(),f);var e=f-d|0;for(d=2;d<a;){b=J(b,f);var g=this.k(d);g=G(H(),g);if(e!==(g-f|0)){b=J(b,g);for(d=1+d|0;d<a;)c=this.k(d),b=J(b,G(H(),c)),d=1+d|0;a=K(b^a);break a}f=g;d=1+d|0}a=K(J(J(c,e),f))}}else if(this instanceof Xc){for(a=
a.ha;!this.e();)this.ba();a=K(a^0)}else a:if(b=a.ha,a=this.o(),a.l())if(c=a.i(),a.l()){d=a.i();e=G(H(),c);c=b=J(b,e);f=G(H(),d);e=f-e|0;for(d=2;a.l();){b=J(b,f);g=a.i();g=G(H(),g);if(e!==(g-f|0)){b=J(b,g);for(d=1+d|0;a.l();)c=a.i(),b=J(b,G(H(),c)),d=1+d|0;a=K(b^d);break a}f=g;d=1+d|0}a=K(J(J(c,e),f))}else a=K(J(b,G(H(),c))^1);else a=K(b^0);return a};X.prototype.g=function(){return eb(this,this.aa()+"(",", ",")")};X.prototype.e=function(){return 0===this.R(0)};function Yc(){}Yc.prototype=new Vc;
Yc.prototype.constructor=Yc;function Zc(){}Zc.prototype=Yc.prototype;function Y(){this.oa=null}Y.prototype=new Zc;Y.prototype.constructor=Y;function $c(){}$c.prototype=Y.prototype;Y.prototype.k=function(a){return this.oa.k(a)};Y.prototype.h=function(){return this.oa.h()};Y.prototype.e=function(){return this.oa.e()};function Z(a){this.oa=a}Z.prototype=new $c;Z.prototype.constructor=Z;Z.prototype.o=function(){return new W(this)};Z.prototype.K=function(){return"IndexedSeqView"};
Z.prototype.R=function(a){var b=this.h();return b===a?0:b<a?-1:1};Z.prototype.$classData=x({ic:0},"scala.collection.IndexedSeqView$Id",{ic:1,nd:1,jd:1,kd:1,ia:1,a:1,ja:1,w:1,la:1,x:1,ka:1,pd:1,c:1,md:1,na:1,ld:1,hb:1});function ad(){}ad.prototype=new Wc;ad.prototype.constructor=ad;function bd(){}bd.prototype=ad.prototype;function cd(){}cd.prototype=new Wc;cd.prototype.constructor=cd;function dd(){}dd.prototype=cd.prototype;
var fd=function ed(a,b){if(0>=b)return F().pa;F();return new S(new M(()=>{if(a.e())return oc();F();var d=T(a).j(),f=ed(T(a).f(),-1+b|0);return new O(d,f)}))};
function gd(a,b,c,d,f){b.b=""+b.b+c;if(!a.m)b.b+="\x3cnot computed\x3e";else if(!a.e()){c=T(a).j();b.b=""+b.b+c;c=a;var e=T(a).f();if(c!==e&&(!e.m||T(c)!==T(e))&&(c=e,e.m&&!e.e()))for(e=T(e).f();c!==e&&e.m&&!e.e()&&T(c)!==T(e);){b.b=""+b.b+d;var g=T(c).j();b.b=""+b.b+g;c=T(c).f();e=T(e).f();e.m&&!e.e()&&(e=T(e).f())}if(!e.m||e.e()){for(;c!==e;)b.b=""+b.b+d,a=T(c).j(),b.b=""+b.b+a,c=T(c).f();c.m||(b.b=""+b.b+d,b.b+="\x3cnot computed\x3e")}else{g=a;for(a=0;;){var n=g,p=e;if(n!==p&&T(n)!==T(p))g=T(g).f(),
e=T(e).f(),a=1+a|0;else break}g=c;n=e;(g===n||T(g)===T(n))&&0<a&&(b.b=""+b.b+d,a=T(c).j(),b.b=""+b.b+a,c=T(c).f());for(;;)if(a=c,g=e,a!==g&&T(a)!==T(g))b.b=""+b.b+d,a=T(c).j(),b.b=""+b.b+a,c=T(c).f();else break;b.b=""+b.b+d;b.b+="\x3ccycle\x3e"}}b.b=""+b.b+f;return b}function S(a){this.lb=null;this.Ka=!1;this.kb=a;this.La=this.m=!1}S.prototype=new bd;S.prototype.constructor=S;h=S.prototype;h.K=function(){return"LinearSeq"};h.h=function(){for(var a=this,b=0;!a.e();)b=1+b|0,a=a.sa();return b};
h.R=function(a){if(0>a)a=1;else a:for(var b=this,c=0;;){if(c===a){a=b.e()?0:1;break a}if(b.e()){a=-1;break a}c=1+c|0;b=b.sa()}return a};h.k=function(a){return Fc(this,a)};function T(a){if(!a.Ka&&!a.Ka){if(a.La)throw a=new Q,L(a,"self-referential LazyList or a derivation thereof has no more elements"),a;a.La=!0;try{var b=(0,a.kb.rb)()}finally{a.La=!1}a.m=!0;a.kb=null;a.lb=b;a.Ka=!0}return a.lb}h.e=function(){return T(this)===oc()};h.j=function(){return T(this).j()};
function yc(a){var b=a,c=a;for(b.e()||(b=T(b).f());c!==b&&!b.e();){b=T(b).f();if(b.e())break;b=T(b).f();if(b===c)break;c=T(c).f()}return a}h.o=function(){return this.m&&this.e()?D().G:new V(this)};h.aa=function(){return"LazyList"};h.$=function(a,b,c,d){yc(this);gd(this,a.q,b,c,d);return a};h.g=function(){var a=new A;gb(a);a.b="LazyList";return gd(this,a,"(",", ",")").b};h.Sa=function(a){return 0>=a?this:this.m&&this.e()?F().pa:zc(F(),this,a)};h.sa=function(){return T(this).f()};
h.$classData=x({zc:0},"scala.collection.immutable.LazyList",{zc:1,ib:1,Fa:1,ia:1,a:1,ja:1,w:1,la:1,x:1,ka:1,Ia:1,Da:1,ta:1,na:1,Ba:1,nb:1,jb:1,ob:1,Hc:1,pc:1,qc:1,Ic:1,c:1});function hd(){this.J=null}hd.prototype=new bd;hd.prototype.constructor=hd;function id(){}h=id.prototype=hd.prototype;h.K=function(){return"IndexedSeq"};h.R=function(a){var b=this.h();return b===a?0:b<a?-1:1};h.h=function(){return this instanceof jd?this.Ja:this.J.d.length};
h.o=function(){return Pc()===this?xb().pb:new Mc(this,this.h(),0)};h.aa=function(){return"Vector"};function Xc(){}Xc.prototype=new bd;Xc.prototype.constructor=Xc;function kd(){}h=kd.prototype=Xc.prototype;h.K=function(){return"LinearSeq"};h.k=function(a){return Fc(this,a)};h.e=function(){return this===E()};h.h=function(){for(var a=0;!this.e();)a=1+a|0,ld();return a};h.R=function(a){if(0>a)a=1;else a:for(;;){if(0===a){a=this.e()?0:1;break a}if(this.e()){a=-1;break a}ld()}return a};h.aa=function(){return"List"};
h.Sa=function(a){a:for(var b=this;;){if(0>=a||b.e())break a;a=-1+a|0;b=b.sa()}return b};function md(){this.J=null}md.prototype=new id;md.prototype.constructor=md;function nd(){}nd.prototype=md.prototype;function jd(){this.J=null;this.Ja=0}jd.prototype=new nd;jd.prototype.constructor=jd;function od(){}od.prototype=jd.prototype;function pd(){qd=this;E();E()}pd.prototype=new kd;pd.prototype.constructor=pd;h=pd.prototype;h.ba=function(){throw new lc("head of empty list");};
function ld(){throw new mc("tail of empty list");}h.o=function(){return D().G};h.sa=function(){ld()};h.j=function(){this.ba()};h.$classData=x({Mc:0},"scala.collection.immutable.Nil$",{Mc:1,td:1,ib:1,Fa:1,ia:1,a:1,ja:1,w:1,la:1,x:1,ka:1,Ia:1,Da:1,ta:1,na:1,Ba:1,nb:1,jb:1,ob:1,Hc:1,pc:1,qc:1,Ic:1,od:1,uc:1,sc:1,Oc:1,wc:1,c:1,ed:1});var qd;function E(){qd||(qd=new pd);return qd}function sd(){this.J=null;this.Ja=0;var a=mb().qb;mb();this.Ja=0;this.J=a}sd.prototype=new od;sd.prototype.constructor=sd;
sd.prototype.k=function(a){throw new Dc(a+" is out of bounds (empty vector)");};sd.prototype.$classData=x({Qc:0},"scala.collection.immutable.Vector0$",{Qc:1,qd:1,vd:1,ud:1,ib:1,Fa:1,ia:1,a:1,ja:1,w:1,la:1,x:1,ka:1,Ia:1,Da:1,ta:1,na:1,Ba:1,nb:1,jb:1,ob:1,rd:1,gb:1,hb:1,sd:1,Oc:1,uc:1,sc:1,wc:1,c:1});var td;function Pc(){td||(td=new sd);return td}function fb(){this.q=null}fb.prototype=new dd;fb.prototype.constructor=fb;h=fb.prototype;h.K=function(){return"IndexedSeq"};
h.o=function(){var a=new Z(this);return new W(a)};h.R=function(a){var b=this.q.h();return b===a?0:b<a?-1:1};h.h=function(){return this.q.h()};h.g=function(){return this.q.b};h.e=function(){return 0===this.q.h()};h.k=function(a){return new k(this.q.b.charCodeAt(a))};h.$classData=x({Sc:0},"scala.collection.mutable.StringBuilder",{Sc:1,wd:1,Fa:1,ia:1,a:1,ja:1,w:1,la:1,x:1,ka:1,Ia:1,Da:1,ta:1,na:1,Ba:1,Fd:1,Dd:1,Gd:1,zd:1,xa:1,Ed:1,xd:1,Ad:1,yd:1,Bd:1,gb:1,hb:1,Cd:1,Ta:1,c:1});ca=new m(0,0);La.sb=ca;
exports.mdoc_js_run0=function(a){Eb||(Eb=new Db);Sb||(Sb=new Rb);var b=Sb.ab.db;for(var c="here!\n";""!==c;){var d=c.indexOf("\n")|0;if(0>d)b.ea=""+b.ea+c,c="";else{var f=""+b.ea+c.substring(0,d);"undefined"!==typeof console&&(b.Nb&&console.error?console.error(f):console.log(f));b.ea="";c=c.substring(1+d|0)}}c=document.createElement("div");b=Zb();b=b.m&&b.e()?F().pa:fd(b,8);b="vega"+eb(b,"","","");c.id=b;a.appendChild(c);c.setAttribute("style","width:0vmin;height:0vmin");fc||(fc=new ec);a=fc;c=new XMLHttpRequest;
c.open("GET","../assets/desktopBrowser.json",!1);c.send();c=JSON.parse(c.responseText);(aa&&"object"===typeof aa&&"default"in aa?aa["default"]:aa)("#"+b,c,a)};
