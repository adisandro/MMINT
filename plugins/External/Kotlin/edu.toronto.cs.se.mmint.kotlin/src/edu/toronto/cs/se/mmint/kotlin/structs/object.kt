package edu.toronto.cs.se.mmint.kotlin.structs

sealed class ObjData {
    override fun toString(): String = this.uri()
}

sealed class VarObject : Object() {}

//data class MkVarObject(val pc : Boolean) : VarObject()

data class MkObjData(val uri : String, val kind: String, val attrs: Map<String, String>, val refs: Map<String, LList<Object>>) : ObjData() {
    override fun toString(): String =
        this.uri()

}

fun ObjData.uri() : String = when (this) { is MkObjData -> this.uri}

fun ObjData.kind() : String =
    when (this) {
        is MkObjData -> this.kind
    }

fun ObjData.attrs() : Map<String, String> =
    when (this) {
        is MkObjData -> this.attrs
    }

fun ObjData.refs() : Map<String, LList<Object>> =
    when (this) {
        is MkObjData -> this.refs
    }

fun ObjData.getAttr(s : String) : String? =
    when (this) {
        is MkObjData -> this.attrs[s]
    }


sealed class Object {
//    override fun toString(): String = "(" + this.data().uri() + "," + this.contains().toString()
}

data class MkObj(val data : ObjData, val contains : Map<String, LList<Object>>) : Object()
{
    override fun toString(): String = "(" + this.data().uri() + "," + this.contains().toString() + ")"
}

fun Object.data() : ObjData = when (this) { is MkObj -> this.data }

fun Object.contains() : Map<String,LList<Object>> = when (this) {is MkObj -> this.contains}

fun Object.children() : LList<Prod<String,LList<Object>>> =
    when(this) {
        is MkObj -> this.contains.toLList()
    }

fun Object.childrenFrom(container : String) : LList<Object> =
    when(val x = this.contains()[container]) {
        null -> Nil
        else -> x
    }

fun <a> Object.mapChildren(f : (Object) -> a) :  LList<Prod<String, LList<a>>> =
    this.children().map { MkProd(it.fst(), it.snd().map(f))}

fun <a> Object.mapAndWrap(f : (Object) -> a) : Map<String,LList<a>> =
    this.mapChildren(f).toMap()

fun Object.mapdata(f : (ObjData) -> ObjData) : Object =
    MkObj(f(this.data()), (this.mapAndWrap { x -> x.mapdata(f) }))

fun <a> Object.fold(f : (ObjData, LList<a>) -> a) : a  =
    f( this.data(), concatLists( this.children().map { it.snd()}).map { it.fold(f)})

fun Object.insertUnderNode(x: Object, container: String, parentURI: String): Object =
    if (this.data().uri() == parentURI)
        MkObj(this.data(), this.contains().addChild(container, x))
    else
        MkObj(this.data(), (this.mapAndWrap { o -> o.insertUnderNode(x, container, parentURI) }))


fun <a> Object.recurseOnChildrenToList(f : (Object) -> LList<a>) : LList<a> =
    concatLists(this.children().map { it -> concatLists(it.snd().map {o -> f(o) })} )

// Rewrite this so it doesn't look so absurd
fun Object.collectMaxSubtreesAsEdges(container : String, parent : String, p: (ObjData) -> Boolean) : LList<Prod<String,Prod<String,String>>> =
    if (p(this.data()))
        append(Cons(MkProd(container, MkProd(parent,this.data().uri())), Nil), recurseOnChildrenToList { o -> o.collectMaxSubtreesAsEdges(container,this.data().uri(),p) })
    else
        concatLists(this.childrenFrom(container).map { o -> o.collectMaxSubtreesAsEdges(container, this.data().uri(), p)})


fun Object.containments() : LList<String> =
    append(this.children().unzip().fst(), recurseOnChildrenToList { o -> o.containments() })

fun Object.replaceNode(new : Object, oldURI : String) : Object =
    if (this.data().uri() == oldURI)
        new
    else
        MkObj(this.data(), this.mapAndWrap { it.replaceNode(new, oldURI) })

fun Object.getSubObject_(uri : String) : Object =
    when (val o = this.getSubObject(uri)) {
        is None -> MkObj(MkObjData("ERROR", "ERROR", mapOf(), mapOf()), mapOf())
        is Some -> o.x
    }

// Todo -- rewrite this
fun Object.getSubObject(uri : String) : Option<Object> =
     when (this) {
        is MkObj -> if (this.data.uri() == uri) Some(this)
        else
            this.children().foldl(
                { p: Prod<String, LList<Object>>, x: Option<Object> ->
                    if (x.isSome())
                        x
                    else
                        p.snd().foldl({ it, y: Option<Object> ->
                            if (y.isSome()) y else
                                it.getSubObject(uri)
                        }, None)
                }, None
            )
    }

