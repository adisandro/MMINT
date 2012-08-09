%include "alloy.grm"

#pragma -newline

%Use the following for making the "complete" predicates.
define completeEntry
	  [id] 		 [repeat id] [repeat id] [repeat id]   [repeat id] [repeat id] [repeat id]
	 %projectionName classTypes  dataTypes   propertyTypes supers      owners      types
end define

define disBinProjMapEntry
	[id] [id]
end define

define ownEntry
	[id] [id] [id] %x:a y:b -> x_o_y a b
end define

define run
	'run [id] for [number] [newline]
|	'run [id] for [id] [newline]
end define

define refEntry
	[repeat ref] [id] [id]
end define

define input
	[model]
%		<[opt ques][tid] [repeat attribute][opt ques][opt /]> [opt newline] 
%	|	</[tid] [repeat attribute]> [opt newline] 
end define

define model
		[header][graph] %[mmtf]
	|	[metamodel] %[expression]
end define

define header
	<?xml version=[stringlit] encoding=[stringlit]?> [newline]
end define

define mmtf
	<'mmtf.common.homomorphism.map:MappingModel xmi:version=[stringlit] xmlns:xmi=[stringlit] xmlns:'mmtf.common.homomorphism.map=[stringlit]> [newline] [repeat link] [repeat projection] </'mmtf.common.homomorphism.map:MappingModel>
end define

define graph
       <randommodel:RandomModel [newline] xmi:version=[stringlit] [newline] xmlns:xmi=[stringlit][newline] xmlns:randommodel=[stringlit] [newline] name=[stringlit] [newline] type=[stringlit]> [newline]
       [repeat node] [repeat edge] </randommodel:RandomModel>
end define

define node
       <nodes name=[stringlit] [opt newline] [ntype] [repeat isMay] /> [newline]
end define

define ntype
       type=[stringlit] [opt newline]
end define

define isMay
		may="true" [opt newline]
       |	var="true"[opt newline]
       |	set="true"[opt newline]
end define

define edge
       <edges name=[stringlit] [opt newline] type=[stringlit] [opt newline] [repeat isMay] src=[stringlit] [opt newline] tgt=[stringlit]  /> [newline]
end define

define numnode
       [id] [id]
end define

define link
		<'link start=[stringlit] 'end=[stringlit]/> [newline]
	|	<'link xmi:'id=[stringlit] start=[stringlit] 'end=[stringlit] />[newline]
end define

define projection
		<'projection name=[stringlit]> [newline] [source] [repeat element] </'projection> [newline]
	|       <'projection xmi:'id=[stringlit] name=[stringlit]> [newline] [source] [repeat element] </'projection> [newline]
end define

define source
	<'source href=[stringlit]/> [newline]
end define

define element
		<'element name=[stringlit] type=[stringlit]> [newline] [source] [repeat ref] </'element> [newline]
	| 	<'element xmi:'id=[stringlit] name=[stringlit] type=[stringlit]> [newline] [source] [repeat ref] </'element> [newline]
end define

define ref
		<'ref target=[stringlit] name=[stringlit]/> [newline]
	|	<'ref name=[stringlit]/>[newline]
	|	<'ref xmi:'id=[stringlit] name=[stringlit]/> [newline]
	|	<'ref xmi:'id=[stringlit] target=[stringlit] name=[stringlit]/> [newline]
end define

define sortdec 
              ([SPOFF]declare-sort[SPON] [id]) [newline]
	|     ([SPOFF]declare-sort[SPON] [id] [number]) [newline]
end define

define fundec
              ([SPOFF]declare-fun[SPON] [id] ([id]) [id]) [newline]
       |      ([SPOFF]declare-fun[SPON] [id] ([id])([id])([id]) [id]) [newline]
       |      ([SPOFF]declare-fun[SPON] [id] () [id]) [newline]
end define

define assertdec
	      ('assert (exists (([id] [id])([id] [id])) (= ([id] [id])([id])))) [newline]
      |	      ('assert (forall (([id] [id])([id] [id]))([SPOFF]=>[SPON] ('not (= [id] [id]))('not (= ([id] [id])([id] [id])))))) [newline]
      |	      ('assert (forall ([id] [id]) ([SPOFF]=>[SPON] (exists ([id] [id]) (= ([id])([id] [id]))) (and [repeat SMTdistinctline])))) [newline]
      |	      ('assert (exists (([id] [id])([id] [id])([id] [id])) (= ([id][id][id])([id])))) [newline]
      |	      [newline]
      |	      ('assert (forall (([id] [id])([id] [id])([id] [id])([id] [id])([id] [id])([id] [id])) ([SPOFF]=>[SPON] (and ('not(= ([id] [id]))) ('not(= ([id] [id]))) ('not(= ([id] [id])))) ('not (= ([id] [id] [id][id])([id] [id] [id] [id]))))))[newline]
      |       ('assert (forall (([id] [id])([id] [id])([id] [id])) ([SPOFF]=>[SPON] (exists ([id] [id])(= ([id])([id] [id] [id] [id]))) (and [repeat SMTdistinctline])))) [newline]
      |	      ('assert (= ([id] [id]) [id])) [newline]
      |       ('assert (forall (([id] [id])([id] [id]))([SPOFF]=>[SPON] (and(=[id] [id])(= [id] [id]))(= [id] [id] )))) [newline]
      |	      ('assert (exists (([id] [id]))(= [id] [id]))) [newline]
      |	      ('assert (forall (([id] [id]))([SPOFF]=>[SPON] (= [id] [id]) (and [repeat SMTdistinctline])))) [newline]
end define

define SMTdistinctline
             ('not (exists ([id] [id]) (= ([id])([id] [id]))))
      |      ('not (exists ([id] [id]) (= ([id])([id] [id] [id] [id]))))
      |	     [empty]
      |	     ('not(= [id] [id]))
end define

define smtproperties
('assert (exists ((x Edges))(= (src x)(tgt x)))) [newline]
('assert (forall ((y Edges))('not(= (src y)(tgt y))))) [newline]
end define


define cspprogram
       [repeat cspvar][cspheader] [cspheaderB]  [repeat setint] [repeat varset] [repeat vardom] [repeat cardconstraint] [repeat edgeconstraint] [csptail]
end define


define csptail
solve satisfy; [newline] output[SPOFF]'[ show(all_nodes),  "\n"'] ++ '[ show(all_edges'[i,1']) ++ "-->" ++ show(all_edges'[i,2']) ++ "\t"[SPON] '| i in 1[SPOFF]..edges'] ++   '["\n ---------- \n"'][SPON]; [newline]
end define

define cardconstraint
	     constraint card[SPOFF]([id])[SPON] = 1; [newline]
      |	     constraint all_nodes[SPOFF]'[[number]'][SPON] = [id]; [newline]
      |	     constraint all_edges[SPOFF]'[[number],[number]'][SPON] = [id]; [newline]
      |	     [newline]
end define

define cspheaderB 
set of int : all_edges_domain = all_nodes_domain union {0}; [newline] array '[1..edges,1..2'] of var all_edges_domain : all_edges; [newline]
end define

define cspheader
        set of int : all_nodes_domain = {[list number]}; [newline] array '[1..nodes'] of var set of all_nodes_domain : all_nodes; [newline]
end define

define setint
		set of int : [id] = { [number] }; [newline]
       |        set of int : [id] = {0} union [id]; [newline]
end define

define cspvar
       int: [id] = [number]; [newline]
end define

define varset
       var set of [id] : [id] ; [newline]
end define

define smtprogram
       [repeat sortdec] [repeat fundec] [repeat assertdec] %[smtproperties] [getcmd]
end define

define vardom
       var [id] : [id]; [newline]
end define

define edgeconstraint
              [SPOFF]constraint(min(card([id]),card([id]))=0 /\ [id] = 0 /\ [id] = 0) \/ (min(card([id]),card([id]))!=0 /\ [id]!=0 /\ [id]!=0)[SPON]; [newline]
	|     [SPOFF]constraint(min(card([id]),card([id]))=0 /\ [id] = 0 /\ [id] = 0) \/ (min(card([id]),card([id]))!=0)[SPON]; [newline]
end define

define getcmd
      [SPOFF] (check-sat)[SPON] [newline]
end define

define ques
	?
end define

define mapEntry
	[id] [number] [id] [id] [number] [id] [id] %Idea: //@type.num/@type.num is mapped, along with the actual name of the element and the type
end define

define newMapEntry
	[stringlit] [id] [id] [id] %name/type/proj?
end define

define nodeEntry
       [stringlit] [stringlit]
end define


define tid
		[id]
	|	[tid].[tid]
	|	[tid]:[tid]
end define

define projEntry
	[number] [id] [id] [list attr]
end define

define projPredEntry
	[id] [repeat nid]
end define

define attr
	[id] [id]
end define

define attribute
		[tid] = [stringlit]
	|	[tid].[tid] = [stringlit]
end define

define sigdef
		sig [id] {} [newline]
	|	sig [id] in [id] {} [newline]
	|	one sig [id] {[id]: [id][SPOFF]->[id][SPON]}{[id] in [id].[id]} [newline]
	|       one sig [id] {[id]: [id][SPOFF]->[id][SPON]}[SPOFF]//[SPON]{[id] in [id].[id]} [newline]
end define

define sigPred
		pred [id] { some [id]:[id] '| [id] in [id] } [newline]
	|	pred [id] { 'all [id],[id]:[id] '| ([id] in [id] and [id] in [id]) implies [id][SPOFF]=[id][SPON]} [newline]
end define

define predicate
		[sigPred]
	|	pred existsforall { [newline] some e: Edges '| 'all x: Nodes '| (('not e[SPOFF].(Source.src) = x[SPON]) and ('not e[SPOFF].(Target.tgt) = x[SPON])) [newline]} [newline]
	|	pred forallexists { [newline] 'all x: Nodes '| some e: Edges '| ([SPOFF](e.(Source.src)=x[SPON]) or ([SPOFF]e.(Target.tgt)=x)[SPON]) [newline] } [newline]
	|	pred universal { [newline] 'all e: Edges '| [SPOFF]e.(Source.src) = e.(Target.tgt)[SPON] [newline] } [newline]
	|	pred [id] { [newline] [repeat nid] } [newline]
	|	fact [id] { [newline] [repeat nid] } [newline]
	|	fact { [newline] 'all [id]:[id] '| [SPOFF][id].([id].[id])[SPON] in [id] } [newline]
	|	pred [id] { 'all [id]:[id] '| 'all [id]:[id] '| ([id] in [id] and [id] in [id]) iff
		 	(some [id]:[id] '| [id][SPOFF]->[id][SPON] in [id].[id])} [newline]
	|	pred [id] { 'all [id],[id]:[id] '| 'all [id],[id]:[id] '| 
			([id][SPOFF]->[id][SPON] in [id].[id] and [id][SPOFF]->[id][SPON] in [id].[id])
			implies ([SPOFF][id]=[id][SPON] and [id][SPOFF]=[id][SPON]) } [newline]
	|	pred [id] { 'all [id]:[id] '| 'all [id]:[id] '| 'all [id]:[id] '| [newline] ([SPOFF][id]->[id][SPON] in [id].[id] implies (
			[repeat distinctPredLine] )) } [newline]
	|	pred [id] { [newline] [repeat distinctPredLine] } [newline]
	|	pred [id] { [newline] [repeat cline] } [newline]
	|	pred [id] { [newline] ([id] and [id]) and 'not [id] [newline] } [newline]
	|	pred [id] { [newline] [repeat transline] } [newline]
	|	pred [id] { [newline] [repeat transline] [repeat id] } [newline] %DEBUG
end define

define cline
		[id] in [repeat idp][newline]
	|	[id].[id] in [repeat idp] [newline]
	|	[SPOFF]//[SPON] [id] in [SPOFF]//Nothing[SPON] of this type was defined [newline]
	|	[SPOFF]//[SPON] [id].[id] in [SPOFF]//Nothing[SPON] of this type was defined [newline]
end define

define transline
		[id] = [repeat idp][newline]
	|	[id].[id] = [repeat idp] [newline]
end define

define transTableEntry
	[id] [repeat transline]
end define

define edgemapping
       [id] [id] [id]
end define

define idp
		[id]
	|	[id]+
	|	([id].[id])+
	|	([id].[id])
end define

define distinctPredLine
		('all [id]:[id] '| ([id] in [id]) implies ('not [id] in [id])) [opt 'and] [newline]
	|	('all [id]:[id] '| 'not [id][SPOFF]->[id][SPON] in [id].[id]) [opt 'and][newline]
	|	[SPOFF]//[SPON]('all [id]:[id] '| ([id] in [id]) implies ('not [id] in [id])) [opt 'and] [newline]
	|	[SPOFF]// [SPON] ('all [id]:[id] '| 'not [id][SPOFF]->[id][SPON] in [id].[id]) [opt 'and][newline]
end define

define program
	[repeat input][repeat output][repeat sigdef][repeat predicate][repeat run][newline]
|	[repeat input][repeat output][repeat projEntry][repeat sigdef][repeat predicate][repeat mapEntry][repeat id][newline] %DEBUGGING
end define

define nid
		[id] [newline]
	| 	[SPOFF]//[SPON] [id] [newline]
end define

define output
		module [id] [opt newline]
	|	[metamodel]
end define


%2512 HERE
define metamodel
abstract sig Nodes {} [newline]
abstract sig Edges {}[newline]
[newline]
one sig Source {src:[SPOFF]Edges->one[SPON] Nodes}[newline]
one sig Target {tgt:[SPOFF]Edges->one[SPON] Nodes}[newline]
[newline]
pred existential {[newline]
some e:Edges '| [SPOFF]e.(Source.src) = e.(Target.tgt)[SPON][newline]
}[newline]
[newline]
pred universal {[newline]
'all e:Edges '| 'not e[SPOFF].(Source.src) = e.(Target.tgt)[SPON][newline]
}[newline]
end define

rule init2
	replace $ [program]
		p[program]
	import em [empty]
	import n [newline]
	construct s [sigdef]
		sig Generalization {} n
	construct ss [sigdef]
		sig Operation {} n
	construct sss [sigdef]
		sig Association {} n
	construct ea [predicate]
pred existsforall { n some e: Edges '| 'all x: Nodes '| (('not e.(Source.src) = x) and ('not e.(Target.tgt) = x)) n} n
     	construct predae [predicate]
		pred forallexists { n 'all x: Nodes '| some e: Edges '| ((e.(Source.src)=x) or (e.(Target.tgt)=x)) n } n
	construct predu [predicate]
		pred universal { n 'all e: Edges '| e.(Source.src) = e.(Target.tgt) n } n
	construct cardconstraints [repeat cardconstraint]
		em
	export cardconstraints
	import predicates [repeat predicate]
	%export predicates
	 %      predicates[. ea][. predae]%[. predu]
	construct finalcalls [repeat nid]
		em
	export finalcalls
	import signatures [repeat sigdef]
	export signatures
		signatures %[. s][. ss][. sss]
	construct bou [id]
		bound
	construct nods[id]
		nodes
	construct edgs [id]
		edges
	import one [number]
	construct five [number]
		one[+ one][+ one][+ one][+ one]
	construct two [number]
		one[+ one]
	construct boundvar [cspvar]
		int: bou = five; n
	construct smtprop [smtproperties]
		('assert (exists ((x Edges))(= (src x)(tgt x)))) n
		('assert (forall ((y Edges))('not(= (src y)(tgt y))))) n
	export smtprop
	construct cspvars [repeat cspvar]
		boundvar
	export cspvars
	construct cspheadB [cspheaderB]
		set of int : all_edges_domain = all_nodes_domain union {0}; n array '[1..edges,1..2'] of var all_edges_domain : all_edges; n
        export cspheadB
	construct nextedge [number]
		one
	export nextedge
	by
		p
end rule

rule init3
	replace $ [program]
     	     p[program]
	import TXLinput [stringlit]
	import em [empty]
	import n [newline]
	import one [number]
	construct edgessort [sortdec]
	     (declare-sort Edges) n
	construct nodessort [sortdec]
	     (declare-sort Nodes) n
	construct nn [id]
	     Nodes
	construct ee [id]
	     Edges
	construct targetfun [fundec]
	     (declare-fun tgt (ee) nn ) n
	construct sourcefun [fundec]
	     (declare-fun src (ee) nn) n
	construct sortdecs [repeat sortdec]
	     edgessort nodessort
	construct fundecs [repeat fundec]
	     targetfun sourcefun
	construct assertdecs [repeat assertdec]
	     em
	construct nodeAnnotations [repeat nodeEntry]
	     em
	export nodeAnnotations
	construct alloyExtension [stringlit]
	     ".als"
	construct smtExtension [stringlit]
	     ".smt2"
	construct cspExtension [stringlit]
	     ".mzn"
	construct AlloyOut [stringlit]
	     TXLinput[+ alloyExtension]
	construct SMTOut [stringlit]
	     TXLinput[+ smtExtension]
	construct CSPOut [stringlit]
	     TXLinput[+ cspExtension]
	construct nextint [number]
	     one
	construct gc [getcmd]
	     (check-sat) n
	construct runfinal [run]
	     'run 'final for 5 n
	construct setints [repeat setint]
	     em
	construct varsets [repeat varset]
	     em
	construct nodeIndex [repeat numnode]
	     em
	construct edgetable [repeat edgemapping]
	     em
	construct vardoms [repeat vardom]
	     em
	construct edgeconstraints [repeat edgeconstraint]
	export vardoms
	export edgeconstraints
	export edgetable
	export nodeIndex
	export setints
	export varsets
	import runs [repeat run]
	export runs
%	       runs[. runfinal]
	export gc
	export nextint
	export AlloyOut
	export SMTOut
	export CSPOut
	export sortdecs
	export fundecs
	export assertdecs
	by
	     p
end rule


rule main
	replace $ [program]
		p[program]
	construct initprog[program]
		p[init][init2][init3]
	import meta [metamodel]
	import n [newline]
	import zero [number]
	import one [number]
	import gc [getcmd]
	construct processInputs[program]
		p[processProgramInputs]
	import nodelist [repeat id]
	import edgelist [repeat id]
	construct processFinalPreds [program]
		p[generateUnaryDistinctPredicatesB nodelist edgelist][makeSMTdistinctAsserts]

	construct processProjPredsP [program]
		p[processFinalPreds][addProjectionChecks][addTranslationPreds][makeLastPred]

	import classes [repeat id]
	import signatures [repeat sigdef]
	import predicates [repeat predicate]
	import runs [repeat run]
	construct em [empty]
	construct emptyrepeatsigdef [repeat sigdef]
		em
	construct emptyrepeatpreds [repeat predicate]
		em
	construct emptyrepeatruns [repeat run]
		em
	import AlloyOut [stringlit]
	construct alloyout [program]
		meta signatures predicates runs n 

	construct writeAlloy [program]
		alloyout[write AlloyOut]
	construct emptyout [program]
		emptyrepeatsigdef emptyrepeatpreds emptyrepeatruns n
	import sortdecs [repeat sortdec]
	import fundecs [repeat fundec]
	import assertdecs [repeat assertdec]
	import smtprop [smtproperties]
	construct smtOut [smtprogram]
	        sortdecs fundecs assertdecs  %smtprop gc
	import SMTOut [stringlit]
%	construct writeSMT [smtprogram]
%		smtOut[write SMTOut]

	import cspvars [repeat cspvar]
	import varsets [repeat varset]
	import setints [repeat setint]
	import cardconstraints [repeat cardconstraint]
	import vardoms [repeat vardom]
	import edgeconstraints [repeat edgeconstraint]
	import cspheadB [cspheaderB]
	import nextint [number]
	construct numbersForHeader [list number]
		em
	export numbersForHeader

	construct makeListNumbers [number]
		one[makeNumList]
	import numbersForHeader
	construct csphead [cspheader]
	        set of int : all_nodes_domain = {numbersForHeader}; n array '[1..nodes'] of var set of all_nodes_domain : all_nodes; n
	construct nods [id]
		nodes
	construct edgs [id]
		edges
	construct nodevar [cspvar]
		int: nods = nextint[- one]; n
	import nextedge [number]
	construct edgevar [cspvar]
		int: edgs = nextedge[- one]; n
	construct tail [csptail]
solve satisfy; n 'output'[ show(all_nodes),  "\n"'] ++ '[ show(all_edges'[i,1']) ++ "-->" ++ show(all_edges'[i,2']) ++ "\t" '| i in 1..edges'] ++ '["\n ---------- \n"']; n
	construct CSPprogOut [cspprogram]
		cspvars[. nodevar][. edgevar] csphead cspheadB  setints varsets vardoms cardconstraints edgeconstraints tail
	import CSPOut [stringlit]
%	construct writeCSP [cspprogram]
%		CSPprogOut[write CSPOut]

	by
		emptyout
end rule

	
function init
	replace [program]
		prog[program]
	deconstruct prog
		ins[repeat input]outs[repeat output]n[newline]
	construct meta [metamodel]
abstract sig Nodes {}n
abstract sig Edges {}n
n
one sig Source {src:Edges->one Nodes}n
one sig Target {tgt:Edges->one Nodes}n
n
pred existential {n
some e:Edges '| e.(Source.src) = e.(Target.tgt)n
}n
n
pred universal {n
'all e:Edges '| 'not e.(Source.src) = e.(Target.tgt)n
}n


	construct em [empty]
	construct projections [repeat id]
		em
	construct projectionEntities [repeat projEntry]
		em
	construct zero [number]
		0
	construct one [number]
		1
	%construct allPredCalls [repeat nid]
	%	em
	construct projectionCounter [number]
		zero
	construct signatures [repeat sigdef]
		em
	construct predicates [repeat predicate]
		em
	construct projectionPredicateInfo [repeat projPredEntry]
		em
	construct classes [repeat id]
		em
	construct datatypes[repeat id]
		em
	construct properties[repeat id]
		em
	construct mapping [repeat mapEntry]
		em
	construct newMapping [repeat newMapEntry]
		em
	construct references [repeat refEntry]
		em
	construct completeTable [repeat completeEntry]
		em
	construct ownTable [repeat ownEntry]
		em
	construct ownTableNames [repeat id]
		em
	construct xx [id]
		XXX
	construct runu [run]
		run universal for xx n
	construct rune [run]
		run existential for xx n
	construct runs [repeat run]
		em %runu rune
	construct disBinProjMap [repeat disBinProjMapEntry]
		em
	construct transTable [repeat transTableEntry]
		em
	construct nodelist [repeat id]
		  em
	construct edgelist [repeat id]
		  em
	export nodelist
	export edgelist
	export newMapping %[repeat newMapEntry]
	export transTable %[repeat transTableEntry]
	export disBinProjMap %[repeat disBinProjMapEntry]
	export runs %[repeat run]
	%export allPredCalls %[repeat nid]
	export ownTableNames %[repeat id]
	export projections %[repeat id]
	export ownTable %[repeat ownEntry]
	export completeTable %[repeat completeEntry]
	export references %[repeat refEntry]
	export mapping %[repeat mapEntry]
	export classes %[repeat id]
	export properties %[repeat id]
	export datatypes %[repeat id]
	export projectionPredicateInfo %[repeat projPredEntry]
	export predicates %[repeat predicate]
	export signatures %[repeat sigdef]
	export em %[empty]
	export projectionCounter %[number]
	export zero %[number]
	export one %[number]
	export projectionEntities %[repeat projEntry]
	export n %[newline]
	export meta %[metamodel]
	by
		prog
end function

function processProgramInputs
	replace [program]
		ins[repeat input]outs[repeat output]n[newline]
	deconstruct ins
		i[input] resti[repeat input]
	deconstruct i
		mod[model]
	deconstruct mod
		h[header] g[graph]
	%construct processedH[header]
	%	h[processHeader]
	construct processedGraph[graph]
		g[processGraph]
	by
		ins outs n
end function


function processGraph
	replace [graph]
	 	g[graph]
	deconstruct g
	       <randommodel:RandomModel q[newline] xmi:version=ver[stringlit] w[newline] xmlns:xmi=ns[stringlit] qw[newline] xmlns:randommodel=nss[stringlit] n[newline] name=t[stringlit] m[newline] type=l[stringlit] > u[newline]
		nodes[repeat node] edges[repeat edge] </randommodel:RandomModel>
	construct processedNodes [repeat node]
		nodes[processNodes]
	construct processedEdges [repeat edge]
		edges[processEdges]
	by
		g
end function

function processProjections projectionCount[number]
	replace[repeat projection]
	 	in[repeat projection]
	deconstruct in
		first[projection] rest[repeat projection]
	construct processedProjection [projection]
		first[processProjection2 projectionCount]%[processProjection2 projectionCount]
	import one [number]
	construct newCount [number]
		projectionCount[+ one]
	construct recursiveCall [repeat projection]
		rest[processProjections newCount]
	by
		in
end function

function processProjection projectionCount[number]
	replace[projection]
		in[projection]
	deconstruct in
		<'projection xmi:'id=ii[stringlit] name=pname[stringlit]> n[newline] src[source] elements[repeat element] </'projection> nn[newline]
	import projectionCounter [number]
	import one [number]
	import em [empty]
	construct elementList [list attr]
		em
	export elementList
	construct processedSource [source]
		src[processSource]
	construct temp [id]
		ERROR
	construct pn [id]
		temp[unquote pname]
	construct predCalls [repeat nid]
		em
	construct six [number]
		6
	construct pnu [id]
		pn[: one six]
	construct ppe [projPredEntry]
		pnu predCalls

	import projections [repeat id]
	export projections
		projections [. pnu]

	import completeTable [repeat completeEntry]
	construct emRepeatIDs [repeat id]
		em
	construct projEntry [completeEntry]
		pnu em em em em em em
	export completeTable
		completeTable[. projEntry]
	
	import projectionPredicateInfo [repeat projPredEntry]
	construct newProjPredTable [repeat projPredEntry]
		em
	export newProjPredTable

	deconstruct * [projPredEntry] projectionPredicateInfo
		pnu calls[repeat nid]


	construct matchingPPE [projPredEntry]
		pnu calls
	construct removeMatched [repeat projPredEntry]
		projectionPredicateInfo[removeProjMatched matchingPPE]
	import newProjPredTable
	export projectionPredicateInfo
		newProjPredTable [. ppe]
	import zero[number]
 	construct processedElements[repeat element]
		elements[processElements pnu projectionCount zero]
	import elementList
	%construct six [number]
	%	6
	%construct pnu [id]
	%	pn[: one six]
	construct pEntry [projEntry]
		projectionCounter pn pnu elementList
	construct addSignatureDefinitions [list attr]
		elementList[addSignatures pnu]
	import projectionEntities [repeat projEntry]
	export projectionEntities
		projectionEntities[. pEntry]
	export projectionCounter
		projectionCounter [+ one]
	by
		in
end function


function processProjection2 projectionCount[number]
	replace[projection]
		in[projection]
	deconstruct in
		<'projection xmi:'id=ii[stringlit] name=pname[stringlit]> n[newline] src[source] elements[repeat element] </'projection> nn[newline]
	import projectionCounter [number]
	import one [number]
	import em [empty]
	construct elementList [list attr]
		em
	export elementList
	construct processedSource [source]
		src[processSource]
	construct temp [id]
		ERROR
	construct pn [id]
		temp[unquote pname]
	construct predCalls [repeat nid]
		em
	construct six [number]
		6
	construct pnu [id]
		pn[: one six]
	construct ppe [projPredEntry]
		pnu predCalls

        import projections [repeat id]
        export projections
                projections [. pnu]



	import completeTable [repeat completeEntry]
	construct emRepeatIDs [repeat id]
		em
	construct projEntry [completeEntry]
		pnu em em em em em em
	export completeTable
		completeTable[. projEntry]
	
	import projectionPredicateInfo [repeat projPredEntry]
	construct newProjPredTable [repeat projPredEntry]
		em
	export newProjPredTable
	deconstruct not * [projPredEntry] projectionPredicateInfo 
		pnu calls[repeat nid]
	construct matchingPPE [projPredEntry]
		pnu predCalls
	construct removeMatched [repeat projPredEntry]
		projectionPredicateInfo[removeProjMatched matchingPPE]
	import newProjPredTable
	export projectionPredicateInfo
		newProjPredTable [. ppe]
	import zero[number]
 	construct processedElements[repeat element]
		elements[processElements pnu projectionCount zero]
	import elementList
	%construct six [number]
	%	6
	%construct pnu [id]
	%	pn[: one six]
	construct pEntry [projEntry]
		projectionCounter pn pnu elementList
	construct addSignatureDefinitions [list attr]
		elementList[addSignatures pnu]
	import projectionEntities [repeat projEntry]
	export projectionEntities
		projectionEntities[. pEntry]
	export projectionCounter
		projectionCounter [+ one]
	by
		in
end function

function removeProjMatched matched [projPredEntry]
	replace [repeat projPredEntry]
		in[repeat projPredEntry]
	deconstruct in
		first[projPredEntry] rest[repeat projPredEntry]
	construct processEntry[projPredEntry]
		first[addToNewTable matched]
	construct recursiveCall [repeat projPredEntry]
		rest[removeProjMatched matched]
	by
		in
end function

function addToNewTable matched [projPredEntry]
	replace [projPredEntry]
		in[projPredEntry]
	where not
		in[= matched]
	import newProjPredTable [repeat projPredEntry]
	export newProjPredTable
		newProjPredTable[. in]
	by
		in
end function


function processSource
	replace[source]
		s[source]
	by
		s
end function

function processElements projName[id] projectionCount[number] elementCounter[number]
	replace [repeat element]
	 	es[repeat element]
	deconstruct es
		first[element] rest[repeat element]
	construct processedElement [element]
		first[processElement projName projectionCount elementCounter]
	import one [number]
	construct newCount[number]
		elementCounter[+ one]
	construct recursiveCall [repeat element]
		rest[processElements projName projectionCount newCount]
	by
		es
end function

function processElement projName[id] projectionCount[number] elementCount[number]
	replace [element]
		in[element]
	import elementList [list attr]
	deconstruct in
		<'element xmi:'id=ii[stringlit] name=ename[stringlit] type=etype[stringlit]> n[newline] src[source] rs[repeat ref] </'element> nn[newline]
	construct temp [id]
		ERROR
	construct en[id]
		 temp[unquote ename]
	construct et[id]
		 temp[unquote etype]
	construct out [attr]
		en et 
	export elementList 
		elementList [, out]
	construct processedRefs [repeat ref]
		rs[exportReferences en et]
	construct proj [id]
		'projection
	construct elem [id]
		'element
%	construct mapEntryOut[mapEntry] 
%		proj projectionCount projName elem elementCount en et

	construct newMapEntryOut [newMapEntry]
		ii en et projName

	import newMapping [repeat newMapEntry]
	export newMapping
		newMapping [. newMapEntryOut]

%	import mapping [repeat mapEntry]
%	export mapping
%		mapping[. mapEntryOut]
	construct addtoCompleteTable [id]
		projName[addToCompleteClasses en et][addToCompleteDatatypes en et][addToCompleteProperties en et] %TODO: make "addToComplete<x> where x is datatypes, types, propertytypes...
	by
		in
end function


function addToCompleteOwns ename[id] etype[id]
        replace [id]
                projName[id]
        construct ow [id]
                Owner
        where
                ow[= etype]
        import completeTable [repeat completeEntry]
        %projectionName classTypes  dataTypes   propertyTypes supers      owners      types
        deconstruct * [completeEntry] completeTable
                projName c[repeat id] d[repeat id] p[repeat id] s[repeat id] o[repeat id] t[repeat id]
        construct matchingEntry [completeEntry]
                projName c d p s o t
        import em[empty]
        construct tempTable [repeat completeEntry]
                em
        export tempTable
        construct tableWithMatchRemoved [repeat completeEntry]
                completeTable[removeMatch matchingEntry]
        construct newOwnList [repeat id]
                o[. ename]
        construct newCompleteEntry [completeEntry]
                projName c d p s newOwnList t
        construct newTable [repeat completeEntry]
                tempTable[. newCompleteEntry]
        export completeTable
                newTable
        by
                projName
end function


function addToCompleteProperties ename[id] etype[id]
        replace [id]
                projName[id]
        construct prop [id]
                Property
        where
                prop[= etype]
        import completeTable [repeat completeEntry]
        %projectionName classTypes  dataTypes   propertyTypes supers      owners      types
        deconstruct * [completeEntry] completeTable
                projName c[repeat id] d[repeat id] p[repeat id] s[repeat id] o[repeat id] t[repeat id]
        construct matchingEntry [completeEntry]
                projName c d p s o t
        import em[empty]
        construct tempTable [repeat completeEntry]
                em
        export tempTable
        construct tableWithMatchRemoved [repeat completeEntry]
                completeTable[removeMatch matchingEntry]
        construct newPropList [repeat id]
                p[. ename]
        construct newCompleteEntry [completeEntry]
                projName c d newPropList s o t
        construct newTable [repeat completeEntry]
                tempTable[. newCompleteEntry]
        export completeTable
                newTable
        by
                projName
end function



function addToCompleteClasses ename[id] etype[id]
	replace [id]
		projName[id]
	construct clas [id]
		Class
	where
		clas[= etype]
	import completeTable [repeat completeEntry]
	%projectionName classTypes  dataTypes   propertyTypes supers      owners      types
	deconstruct * [completeEntry] completeTable
		projName c[repeat id] d[repeat id] p[repeat id] s[repeat id] o[repeat id] t[repeat id]
	construct matchingEntry [completeEntry]
		projName c d p s o t
	import em[empty]
	construct tempTable [repeat completeEntry]
		em
	export tempTable
	construct tableWithMatchRemoved [repeat completeEntry]
		completeTable[removeMatch matchingEntry]
	construct newClassList [repeat id]
		c[. ename]
	construct newCompleteEntry [completeEntry]
		projName newClassList d p s o t
	construct newTable [repeat completeEntry]
		tempTable[. newCompleteEntry]
	export completeTable
		newTable
	by
		projName
end function


function addToCompleteDatatypes ename[id] etype[id]
        replace [id]
                projName[id]
        construct data [id]
                Datatype
        where
                data[= etype]
        import completeTable [repeat completeEntry]
        %projectionName classTypes  dataTypes   propertyTypes supers      owners      types
        deconstruct * [completeEntry] completeTable
                projName c[repeat id] d[repeat id] p[repeat id] s[repeat id] o[repeat id] t[repeat id]
        construct matchingEntry [completeEntry]
                projName c d p s o t
        import em[empty]
        construct tempTable [repeat completeEntry]
                em
        export tempTable
        construct tableWithMatchRemoved [repeat completeEntry]
                completeTable[removeMatch matchingEntry]
        construct newDatatypeList [repeat id]
                d[. ename]
        construct newCompleteEntry [completeEntry]
                projName c newDatatypeList p s o t
        construct newTable [repeat completeEntry]
                tempTable[. newCompleteEntry]
        export completeTable
                newTable
        by
                projName
end function



function removeMatch matchIn [completeEntry]
	replace [repeat completeEntry]
		tableIn[repeat completeEntry]
	deconstruct tableIn
		first[completeEntry] rest[repeat completeEntry]
	construct processedEntry [completeEntry]
		first[removeMatchA matchIn]
	construct recursiveCall [repeat completeEntry]
		rest[removeMatch matchIn]
	by
		tableIn
end function

function removeMatchA matchIn [completeEntry]
	replace [completeEntry]
		c[completeEntry]
	where not
		c[= matchIn]
	import tempTable [repeat completeEntry]
	export tempTable
		tempTable[. c]
	by
		c
end function




function exportReferences elementName[id] elementType[id]
	replace [repeat ref]
		rs[repeat ref]
	import references [repeat refEntry]
	construct refsOut [refEntry]
		rs elementName elementType
	export references
		references[. refsOut]
	by
		rs
end function

function addSignatures projName[id]
	replace [list attr]
		in[list attr]
	deconstruct in
		first[attr], rest[list attr]
	construct sigOut [attr]
		first[makeSig projName]
	construct recursiveCall[list attr]
		rest[addSignatures projName]
	by
		in
end function

function makeSig projName[id]
	replace [attr]
		inattr[attr]
	import signatures [repeat sigdef]
	import n [newline]
	deconstruct inattr
		name[id] type[id]
	construct em[empty]
%	construct eid[id]
%		em
	import zero [number]
	construct lenName [number]
		zero[# name]
	construct lenType[number]
		zero[# type]
	where not
		lenName[= zero]
	where not
		lenType[= zero]
	construct outid [id]
		name[_ projName]
	construct out [sigdef]
		sig outid in type {} n
	construct processedSigDistinct [id]
		outid[addToDatatypes type][addToProperties type][addToClasses type]		
	construct exists [id]
		exists
	construct uniq [id]
		unique
	construct var [id]
		x
	construct varTwo [id]
		y
	construct sigPredOutE [sigPred]
		pred exists[_ outid] { some var : type '| var in outid } n
	construct predOutE [predicate]
		sigPredOutE
	construct sigPredOutU [sigPred]
		pred uniq[_ outid] { 'all var, varTwo : type '| (var in outid and varTwo in outid) implies var=varTwo} n

	%import allPredCalls [repeat nid]

	construct sPOUn [nid]
		uniq[_ outid] n
	construct sPOEn [nid]
		exists[_ outid] n
	construct MAVOFilteredU [nid]
		sPOUn[mavoFilterS]
	construct MAVOFilteredE [nid]
		sPOEn[mavoFilterM]


	%export allPredCalls
	%	allPredCalls[. sPOEn][. sPOUn]

	construct predOutU [predicate]
		sigPredOutU
	import predicates [repeat predicate]
	export predicates
		predicates[. predOutE][. predOutU]
	export signatures
		signatures[. out]
	import projectionPredicateInfo[repeat projPredEntry]
	deconstruct * [projPredEntry] projectionPredicateInfo
		projName  is[repeat nid]


        construct newProjPredTable [repeat projPredEntry]
                em
        export newProjPredTable


        construct matchingPPE [projPredEntry]
                projName is
        construct removeMatched [repeat projPredEntry]
                projectionPredicateInfo[removeProjMatched matchingPPE]
        import newProjPredTable



	construct predNameE [id]
		exists[_ outid] 
	construct predNameU [id]
		uniq[_ outid]
	construct predNameUN [nid]
		predNameU n
	construct predNameEN [nid]
		predNameE n
	construct idsout [repeat nid]
		is [.MAVOFilteredU][.MAVOFilteredE]%[. sPOUn][. sPOEn]%[. predNameEN][. predNameUN]
	construct ppeOut [projPredEntry]
		projName  idsout
	export projectionPredicateInfo
		newProjPredTable[. ppeOut]
	by
		inattr
end function


function processFinalPreds
	replace [program]
		p[program]
	import projectionPredicateInfo [repeat projPredEntry]
	construct preds [repeat projPredEntry]
		projectionPredicateInfo[makeFinalPred]
	by
		p
end function


function makeFinalPred
	replace [repeat projPredEntry]
		in[repeat projPredEntry]
	deconstruct in
		first[projPredEntry] rest[repeat projPredEntry]
	construct out [projPredEntry]
		first[actuallyMakePred]
	construct recursiveCall [repeat projPredEntry]
		rest[makeFinalPred]
	by
		in
end function

function actuallyMakePred
	replace [projPredEntry]
		in[projPredEntry]
	import n [newline]
	deconstruct in
		name[id] calls[repeat nid]
	construct emp [id]
		em
	where not
		name [= emp]
		

%	import allPredCalls [repeat nid]

	construct mav [id]
		MAVO
	construct predName [id]
		mav[_ name]
	construct comp [id]
		complete
	construct addCompleteN [nid]
		comp[_ name] n
	construct predOut [predicate]
		pred predName { n calls[. addCompleteN]  } n
%		pred name { n allPredCalls } n
	import predicates [repeat predicate]
	export predicates
		predicates[. predOut]
	by
		in
end function


function addToProperties type[id]
	replace	[id]
		name[id]
	construct p [id]
		Property
	where
		type [= p]
	import properties [repeat id]
	export properties
		properties[. name]
	by
		name
end function

function addToDatatypes type[id]
	replace [id]
		name[id]
	construct d[id]
		Datatype
	where
		type [= d]
	import datatypes [repeat id]
	export datatypes
		datatypes[. name]
	by
		name
end function

function addToClasses type[id]
	replace [id]
		name[id]
	construct c [id]
		Class
	where
		type[= c]
	import classes [repeat id]
	export classes
		classes[.name]
	by
		name
end function

function generateUnaryDistinctPredicates
	replace [program]
		p[program]
	import completeTable [repeat completeEntry]
	construct ctp [repeat completeEntry]
		completeTable[GUDP p]
	by
		p
end function

function GUDP pr[program]
	replace [repeat completeEntry]
		in[repeat completeEntry]
	import nodelist [repeat id]
	import edgelist [repeat id]
	construct pp [program]
		pr[generateUnaryDistinctPredicatesB nodelist edgelist]
	by
		in
end function


function generateUnaryDistinctPredicatesB  nodelist[repeat id] edgelist[repeat id]
	replace [program]
		p[program]

	import zero[number]
	construct em [empty]
	construct emIDs [repeat id]
		em
	construct c [id]
		Nodes
	construct d [id]
		Edges
	construct unaryClasses [repeat id]
		nodelist[makeUnaryDistinct2 nodelist c]
	construct edges [repeat id]
		edgelist [makeUnaryDistinct2B edgelist d]
	construct distinctEdges [repeat id]
		edgelist[makeUnaryDistinct2 edgelist d]
	by
		p
end function

function makeUnaryDistinct2 copyOfInput[repeat id] type[id] 
	replace [repeat id]
		in[repeat id]
	deconstruct in
		first[id] rest[repeat id]
	import em [empty]
	construct emIDs [repeat id]
		em
	export emIDs
	construct filterCopy [repeat id]
		copyOfInput[filterID first]
	import emIDs
	construct processed [id]
		first[makeThePred emIDs type]
	construct recursiveCall [repeat id]
		rest[makeUnaryDistinct2 copyOfInput type]
	by
		in
end function

function makeUnaryDistinct2B copyOfInput[repeat id] type[id] 
	replace [repeat id]
		in[repeat id]
	deconstruct in
		first[id] rest[repeat id]
	import em [empty]
	construct emIDs [repeat id]
		em
	export emIDs
	construct filterCopy [repeat id]
		copyOfInput[filterID first]
	import emIDs
	construct processed [id]
		first[makeThePredB emIDs type]
	construct recursiveCall [repeat id]
		rest[makeUnaryDistinct2B copyOfInput type]
	by
		in
end function


function makeThePred compareWith[repeat id] type[id]
	replace [id]
		in[id]
	construct dis [id]
		distinct
	construct predName [id]
		dis[_ in]
	import n [newline]
	import em [empty]
	construct predLines [repeat distinctPredLine]
		em
	export predLines
	construct makeLines [id]
		in[makeDPLines compareWith type][makeDPLines2 compareWith type]
	import predLines
	construct predOut [predicate]
		pred predName { n predLines } n
	construct prednid [nid]
		predName n
	construct filteredPredNid [nid]
		prednid[mavoFilterU]
	import finalcalls [repeat nid]
	export finalcalls
	       finalcalls[. filteredPredNid]

	construct nvar [id]
	        x
	construct ntype [id]
		Nodes
	construct avar [id]
		a
	construct alines [repeat SMTdistinctline]
		em
	export alines
	construct makeALines [id]
		in[makeDALines compareWith ntype][makeDALines2 compareWith ntype]
	import alines
	construct assertout [assertdec]
%		('assert (forall (nvar ntype) (=> (exists (avar in)(= (nvar)(avar[_ ntype] avar))) (and alines) ))) n
	        ('assert (forall ((nvar type))(=> (= nvar in) (and alines)))) n
	import assertdecs [repeat assertdec]
	export assertdecs
	       assertdecs [. assertout]

	import predicates [repeat predicate]
	export predicates
		predicates[.predOut]
	by
		in
end function

function makeThePredB compareWith[repeat id] type[id]
	replace [id]
		in[id]
	import n [newline]
	import em [empty]
	import edgetable [repeat edgemapping]
	deconstruct * [edgemapping] edgetable
		in src[id] tgt[id]
	construct evar [id]
	        e
	construct ntype [id]
		Edges
	construct xvar [id]
		x
	construct yvar [id]
		y
	construct ins [id]
		instance
	construct alinesB [repeat SMTdistinctline]
		em
	construct funcname [id]
		in[_ ntype] 
	export alinesB
	construct makeALinesB [id]
		in[makeDALinesB compareWith ntype src tgt][makeDALines2B compareWith ntype src tgt]
	import alinesB
	construct assertout [assertdec]
%		('assert (forall ((evar ntype)(xvar src)(yvar tgt)) (=> (exists (in[_ ins] in)(= (evar)(funcname xvar yvar evar))) (and alinesB)))) n
	      ('assert (forall ((xvar ntype))(=> (= xvar in) (and alinesB)))) n
	import assertdecs [repeat assertdec]
	export assertdecs
	       assertdecs [. assertout]

	by
		in
end function


function makeDPLines compareWith[repeat id] type[id]
	replace [id]
		name[id]
	deconstruct compareWith
		first[id] rest[repeat id]
	import predLines [repeat distinctPredLine]
	import zero [number]
	construct restLen [number]
		zero[length rest]
	where not
		zero[= restLen]
	construct xvar [id]
		x
	import n [newline]
	construct predline [distinctPredLine]
		('all xvar: type '| (xvar in name) implies ('not xvar in first)) n %ADD AND HERE IF NECESSARY
        construct predlineFiltered[distinctPredLine]
                predline[mavoFilterU2][mavoFilterU3]
	export predLines
		predLines[. predlineFiltered]
	construct recursiveCall [id]
		name[makeDPLines rest type][makeDPLines2 rest type]
	by
		name
end function


function makeDPLines2 compareWith[repeat id] type[id] 
        replace [id]
                name[id]
        deconstruct compareWith
                first[id] rest[repeat id]
        import predLines [repeat distinctPredLine]
        import zero [number]
        construct restLen [number]
                zero[length rest]
        where 
                zero[= restLen]
        construct xvar [id]
                x
        import n [newline]
        construct predline [distinctPredLine]
                ('all xvar: type '| (xvar in name) implies ('not xvar in first)) n
	construct predlineFiltered[distinctPredLine]
		predline[mavoFilterU2][mavoFilterU3]
        export predLines
                predLines[. predlineFiltered]
        construct recursiveCall [id]
                name[makeDPLines rest type][makeDPLines2 rest type]
        by                                           
                name
end function


function filterID toFilter[id]
	replace [repeat id]
		in[repeat id]
	deconstruct in
		first[id] rest[repeat id]
	construct emIDsUpdated [id]
		first[addToEmIDS toFilter]
	construct recursiveCall [repeat id]
		rest[filterID toFilter]
	by
		in
end function

function addToEmIDS toFilter[id]
	replace [id]
		in[id]
	where not
		in [= toFilter]
	import emIDs [repeat id]
	export emIDs
		emIDs[. in]
	by
		in
end function


function makeUnaryDistinct length[number] counter[number] inputIDs[repeat id] type[id]
	replace [repeat id]
		in[repeat id]
	where not
		counter[= length]
	deconstruct in
		first[id] rest[repeat id]
	construct allIDs [repeat id]
		in[. inputIDs]
	construct firstRepeat [repeat id]
		first
	construct otherIDs [repeat id]
		allIDs[filter firstRepeat]
	construct predOut [id]
		first[makeUnaryDisPred otherIDs type]
	import one [number]
	construct counted [number]
		counter[+ one]
	%construct firstRepeat [repeat id]
	%	first
	construct recursiveCall [repeat id]
		rest[makeUnaryDistinct length counted firstRepeat type]
	by
		in
end function

function makeUnaryDisPred otherIDs[repeat id] type[id]
	replace [id]
		in[id]
	construct em [empty]
	construct lines [repeat distinctPredLine]
		em
	export lines
	construct processLines [repeat id]
		otherIDs[makeLine in type][makeLine2 in type]
	import lines
	construct dis [id]
		distinct
	construct predName [id]
		dis[_ in]
	import n [newline]
	construct predOut [predicate]
		pred predName { n lines } n
	import predicates [repeat predicate]

%	import allPredCalls [repeat nid]
%TODO: expor the predCall, requires projection name.
	construct predNid [nid]
		predName n

%	export allPredCalls
%		allPredCalls[. predNid]

	export predicates
		predicates[.predOut]
	by
		in
end function

function makeLine iid[id] type[id]
	replace [repeat id]
		ins[repeat id]
	deconstruct ins
		first[id] rest[repeat id]
	import zero [number]
	construct restLen [number]
		zero[length rest]
	where
		zero [= restLen]
	construct xvar [id]
		x
	import n [newline]
	construct line [distinctPredLine]
		('all xvar: type '| (xvar in iid) implies ('not xvar in first)) n
	import lines [repeat distinctPredLine]
	export lines
		lines [. line]
	construct recursiveCall [repeat id]
		rest[makeLine iid type][makeLine2 iid type]
	by
		ins
end function

function makeLine2 iid[id] type[id]
        replace [repeat id]
                ins[repeat id]
        deconstruct ins
                first[id] rest[repeat id]
        import zero [number]
        construct restLen [number]
                zero[length rest]
        where not
                zero [= restLen]
        construct xvar [id]
                x
        import n [newline]
        construct line [distinctPredLine]
                ('all xvar: type '| (xvar in iid) implies ('not xvar in first)) and n
        import lines [repeat distinctPredLine]
        export lines
                lines [. line]
        construct recursiveCall [repeat id]
                rest[makeLine iid type][makeLine2 iid type]
        by
                ins
end function


function filter rs[repeat id]
        replace [repeat id]
                in[repeat id]
        deconstruct in
                first[id] rest[repeat id]
        construct recurse [repeat id]
                rest[filter rs]
        construct temprepeat [repeat id]
                first
        construct out [repeat id]
                temprepeat[filterSingle rs]
        by
                recurse[.out]
end function

function filterSingle rs[repeat id]
        replace [repeat id]
                in[repeat id]
        deconstruct rs
                first[id] rest[repeat id]
        construct out [repeat id]
                in[replaceIfMatch first]
        construct recurse[repeat id]
                out[filterSingle rest]
        by
                recurse
end function


function replaceIfMatch i[id]
        replace [repeat id]
                is [repeat id]
        deconstruct is
                first[id] rest[repeat id]
        where
                first [= i]
        by
                rest
end function


function processAllReferences
	replace [program]
		p[program]
	import references [repeat refEntry]
	construct processed [repeat refEntry]
		references[processReferencesHelper]
	by
		p
end function

function processReferencesHelper
	replace [repeat refEntry]
		in[repeat refEntry]
	deconstruct in
		first[refEntry] rest[repeat refEntry]
	deconstruct first
		refs[repeat ref] elementName[id] elementType[id]
	construct processedRefs[repeat ref]
		refs[processReferences elementName elementType]
	construct recursiveCall [repeat refEntry]
		rest[processReferencesHelper]
	by
		in
end function

function processReferences elementName[id] elementType[id]
	replace [repeat ref]
		rs[repeat ref]
	deconstruct rs
		first[ref] rest[repeat ref]
	construct processedRef [ref]
		first[processRef elementName elementType][processRef2 elementName elementType]
	construct recursiveCall [repeat ref]
		rest[processReferences elementName elementType]
	by
		rs
end function


function processRef2 elementName[id] elementType[id] %This will handle two attribute references, specifically those with name ownedattribute. %TODO: handle other types (like, class)
	replace [ref]
		<'ref xmi:'id=ii[stringlit] target=tar[stringlit] name=nam[stringlit]/> n[newline]
	construct temp [id]
		ERROR
construct cla [id]
	Class
where
	elementType[= cla]


	construct refName [id]
		temp[unquote nam] 
	construct owned [id]
		ownedAttribute
	construct oneNum [number]
		1
	construct lenTar [number]
		oneNum[# tar]
	construct fifteen [number]
		15
	construct trimmedFirstSection [stringlit] %"//projection.0/element.1" -> "0/element.0"
		tar[: fifteen lenTar]
	construct two [number]
		2
	construct getProjNumber [stringlit]
		trimmedFirstSection[: oneNum oneNum] 
	construct projNumber [number]
		two[unquote getProjNumber]
	construct lenFirstTrim [number]
		two[# trimmedFirstSection]
	construct trimmedSecondSection [stringlit] %"0/element.1" -> "1"
		trimmedFirstSection[: lenFirstTrim lenFirstTrim]
	construct eleNumber [number]
		two[unquote trimmedSecondSection] 
%	import mapping [repeat mapEntry]
	construct proj [id]
		'projection
	construct ele [id]
		'element
	construct zero [number]
		0
 

%	deconstruct * [mapEntry] mapping
%		proj projNumber projName[id] ele eleNumber iName[id] iType[id]

	import newMapping [repeat newMapEntry]
	deconstruct * [newMapEntry] newMapping
		tar iName[id] iType[id] projName[id]

%construct tempdee [id]
%	iType[_ iType]
%OMG
construct oa [id]
	ownedAttribute
where
	refName[= oa]

construct oar [id]
	ownerAttribute
	construct lenName [number]
		zero[# iName] 
	where not
		zero [= lenName]
	%construct refName [id]
	%	ele[unquote nam]
construct oown [id]
	owner
	construct oName [id]
		elementName[_ refName][_ iName] 
	construct sigout [sigdef]
		one sig oName[_ projName] {oown[_ oName][_ projName]: elementName[_ projName]->iName[_ projName]}  {oown[_ oName][_ projName] in OwnerAttribute.oar} n
	import signatures [repeat sigdef]
	export signatures
		signatures[. sigout]	

	where %TODO: move this higher in the function
		refName [= owned]
	construct ex [id]
		exists
	construct predName [id]
		ex[_ oName] 
	construct xvar [id]
		x
	construct yvar [id]
		y
	construct zvar [id]
		z
	construct ow [id]
		owner
	construct predOut [predicate]
		pred predName[_ projName] { 'all xvar: elementType '| 'all yvar: iType '| (xvar in elementName[_ projName] and yvar in iName[_ projName]) iff
			(some zvar:oName[_ projName] '| xvar->yvar in zvar.ow[_ oName][_ projName])} n
	construct uniq [id]
		unique
	construct predNameU [id]
		uniq[_ oName]
	construct xvart [id]
		x2
	construct yvart [id]
		y2 

	construct predOutUniq [predicate]
		pred predNameU[_ projName] { 'all xvar, xvart: elementType '| 'all yvar, yvart: iType '| (xvar->yvar in oName[_ projName].ow[_ oName][_ projName] and
			xvart->yvart in oName[_ projName].ow[_ oName][_ projName]) implies (xvar=xvart and yvar=yvart)} n


	import ownTable [repeat ownEntry]
	construct oeOut [ownEntry]
		oName elementType iType
	export ownTable
		ownTable[. oeOut]
	import ownTableNames [repeat id]
	export ownTableNames
		ownTableNames[. oName]


%	import allPredCalls [repeat nid]

	construct nPredName [nid]
		predName[_ projName] n 
	construct nPredNameU [nid]
		predNameU[_ projName] n 
	import projectionPredicateInfo [repeat projPredEntry]
	deconstruct * [projPredEntry] projectionPredicateInfo
		projName cs[repeat nid]

	construct matchingPE [projPredEntry]
		projName cs

construct nPredNameFiltered [nid]
	nPredName[mavoFilterM]
construct nPredNameUFiltered [nid]
	nPredNameU[mavoFilterS]

	construct outPE [projPredEntry]
		projName cs[. nPredNameFiltered][. nPredNameUFiltered]
	construct newProjPredTable [repeat projPredEntry]
		em
	export newProjPredTable
	construct newTable [repeat projPredEntry]
		projectionPredicateInfo[removeProjMatched matchingPE]
	import newProjPredTable
	export projectionPredicateInfo
		newProjPredTable[. outPE]


%	export allPredCalls
%		allPredCalls[.nPredName][.nPredNameU]

        construct dis [id]
                distinct
        construct predNameD [id]
                dis[_ oName]

	import disBinProjMap [repeat disBinProjMapEntry]
	construct newTentry[disBinProjMapEntry]
		projName predNameD
	export disBinProjMap
		disBinProjMap[. newTentry]

	construct oww[id]
		Owner
	construct finalSigName [id]
		oName[_ projName]
	construct addToComplete [id]
		projName[addToCompleteOwns finalSigName oww]		

%	construct dis [id]
%		distinct
%	construct predNameD [id]
%		dis[_ oName]
%	import em[empty]
%	construct dlines [repeat distinctPredLine]
%		em
%	construct predOutDist [predicate]
%		pred predNameD { 'all xvar: elementType '| 'all yvar: iType '| 'all zvar:oName '| n (xvar->yvar in zvar.ow implies (
%			dlines )) } n
%
	import predicates [repeat predicate]
	export predicates
		predicates[. predOut][.predOutUniq] %[.predOutDist]
	by
		<'ref xmi:'id=ii target=tar name=nam /> n
end function


function processRef elementName[id] elementType[id] %This will handle two attribute references, specifically those with name ownedattribute. %TODO: handle other types (like, class)
	replace [ref]
		<'ref xmi:'id=ii[stringlit] target=tar[stringlit] name=nam[stringlit]/> n[newline]
	construct temp [id]
		ERROR
construct cla [id]
	Class
where
	elementType[= cla]


	construct refName [id]
		temp[unquote nam] 
	construct owned [id]
		ownedOperation
	construct oneNum [number]
		1
	construct lenTar [number]
		oneNum[# tar]
	construct fifteen [number]
		15
	construct trimmedFirstSection [stringlit] %"//projection.0/element.1" -> "0/element.0"
		tar[: fifteen lenTar]
	construct two [number]
		2
	construct getProjNumber [stringlit]
		trimmedFirstSection[: oneNum oneNum] 
	construct projNumber [number]
		two[unquote getProjNumber]
	construct lenFirstTrim [number]
		two[# trimmedFirstSection]
	construct trimmedSecondSection [stringlit] %"0/element.1" -> "1"
		trimmedFirstSection[: lenFirstTrim lenFirstTrim]
	construct eleNumber [number]
		two[unquote trimmedSecondSection] 
%	import mapping [repeat mapEntry]
	construct proj [id]
		'projection
	construct ele [id]
		'element
	construct zero [number]
		0
 

%	deconstruct * [mapEntry] mapping
%		proj projNumber projName[id] ele eleNumber iName[id] iType[id]

	import newMapping [repeat newMapEntry]
	deconstruct * [newMapEntry] newMapping
		tar iName[id] iType[id] projName[id]

%construct tempdee [id]
%	iType[_ iType] 
%OMG
construct oo [id]
	ownedOperation
where
	refName[= oo]

	construct lenName [number]
		zero[# iName] 
	where not
		zero [= lenName]
	%construct refName [id]
	%	ele[unquote nam]
	construct oName [id]
		elementName[_ refName][_ iName] 
	construct ooA [id]
		OwnedOperation
construct oor [id]
	ownerOperation
construct OOR [id]
	OwnerOperation
construct oown [id]
	owner
	construct sigout [sigdef]
		one sig oName[_ projName] {oown[_ oName][_ projName]: elementName[_ projName]->iName[_ projName]} {oown[_ oName][_ projName] in OOR.oor} n
	import signatures [repeat sigdef]
	export signatures
		signatures[. sigout]

	where %TODO: move this higher in the function
		refName [= owned]
	construct ex [id]
		exists
	construct predName [id]
		ex[_ oName] 
	construct xvar [id]
		x
	construct yvar [id]
		y
	construct zvar [id]
		z
	construct predOut [predicate]
		pred predName[_ projName] { 'all xvar: elementType '| 'all yvar: iType '| (xvar in elementName[_ projName] and yvar in iName[_ projName]) iff
			(some zvar:oName[_ projName] '| xvar->yvar in zvar.oown[_ oName][_ projName])} n
	construct uniq [id]
		unique
	construct predNameU [id]
		uniq[_ oName]
	construct xvart [id]
		x2
	construct yvart [id]
		y2 

	construct predOutUniq [predicate]
		pred predNameU[_ projName] { 'all xvar, xvart: elementType '| 'all yvar, yvart: iType '| (xvar->yvar in oName[_ projName].oown[_ oName][_ projName] and
			xvart->yvart in oName[_ projName].oown[_ oName][_ projName]) implies (xvar=xvart and yvar=yvart)} n


	import ownTable [repeat ownEntry]
	construct oeOut [ownEntry]
		oName elementType iType
	export ownTable
		ownTable[. oeOut]
	import ownTableNames [repeat id]
	export ownTableNames
		ownTableNames[. oName]


%	import allPredCalls [repeat nid]

	construct nPredName [nid]
		predName[_ projName] n
	construct nPredNameU [nid]
		predNameU[_ projName] n
	import projectionPredicateInfo [repeat projPredEntry]
	deconstruct * [projPredEntry] projectionPredicateInfo
		projName cs[repeat nid]

	construct matchingPE [projPredEntry]
		projName cs

construct nPredNameFiltered [nid]
	nPredName[mavoFilterM]
construct nPredNameUFiltered [nid]
	nPredNameU[mavoFilterS]

	construct outPE [projPredEntry]
		projName cs[. nPredNameFiltered][. nPredNameUFiltered]
	construct newProjPredTable [repeat projPredEntry]
		em
	export newProjPredTable
	construct newTable [repeat projPredEntry]
		projectionPredicateInfo[removeProjMatched matchingPE]
	import newProjPredTable
	export projectionPredicateInfo
		newProjPredTable[. outPE]


%	export allPredCalls
%		allPredCalls[.nPredName][.nPredNameU]

        construct dis [id]
                distinct
        construct predNameD [id]
                dis[_ oName]

	import disBinProjMap [repeat disBinProjMapEntry]
	construct newTentry[disBinProjMapEntry]
		projName predNameD
	export disBinProjMap
		disBinProjMap[. newTentry]

	construct ow[id]
		Owner
	construct finalSigName [id]
		oName[_ projName]
	construct addToComplete [id]
		projName[addToCompleteOwns finalSigName ow]		

	import predicates [repeat predicate]
	export predicates
		predicates[. predOut][.predOutUniq] %[.predOutDist]
	by
		<'ref xmi:'id=ii target=tar name=nam /> n
end function

function processLinks
	replace [repeat link]
		ls[repeat link]
	deconstruct ls
		first[link] rest[repeat link]
	construct processedLink [link]
		first[processLink]
	construct recursiveCall [repeat link]
		rest[processLinks]
	by
		ls
end function

function processLink
	replace [link]
		<'link xmi:'id=ii[stringlit] start=star[stringlit] 'end=en[stringlit]/> n[newline]	
        import one [number]
        construct lenStar [number]
                one[# star]
        construct fifteen [number]
                15
        construct trimmedFirstSectionStart [stringlit] %"//projection.0/element.1" -> "0/element.0"
                star[: fifteen lenStar]
        construct two [number]
                2
        construct getProjNumberStart [stringlit]
                trimmedFirstSectionStart[: one one]
        construct projNumberStart [number]
                two[unquote getProjNumberStart]
        construct lenFirstTrimStart [number]
                two[# trimmedFirstSectionStart]
        construct trimmedSecondSectionStart [stringlit] %"0/element.1" -> "1"
                trimmedFirstSectionStart[: lenFirstTrimStart lenFirstTrimStart]
        construct eleNumberStart [number]
                two[unquote trimmedSecondSectionStart]
%        import mapping [repeat mapEntry]

        construct proj [id]
                'projection
        construct ele [id]
                'element
%        deconstruct * [mapEntry] mapping 
%                proj projNumberStart projNameDec[id] ele eleNumberStart startName[id] startType[id]


	import newMapping [repeat newMapEntry]
	deconstruct * [newMapEntry] newMapping
		star startName[id] startType[id] projNameDec[id]

        construct lenEn [number]
                one[# en]
        construct trimmedFirstSectionEnd [stringlit] %"//projection.0/element.1" -> "0/element.0"
                en[: fifteen lenEn]
        construct getProjNumberEnd [stringlit]
                trimmedFirstSectionEnd[: one one]
        construct projNumberEnd [number]
                two[unquote getProjNumberEnd]
        construct lenFirstTrimEnd [number]
                two[# trimmedFirstSectionEnd]
        construct trimmedSecondSectionEnd [stringlit] %"0/element.1" -> "1"
                trimmedFirstSectionEnd[: lenFirstTrimEnd lenFirstTrimEnd]
        construct eleNumberEnd [number]
                two[unquote trimmedSecondSectionEnd]
%        deconstruct * [mapEntry] mapping
%                proj projNumberEnd projName[id] ele eleNumberEnd endName[id] endType[id]

	deconstruct * [newMapEntry] newMapping
		en endName[id] endType[id] projName[id]

	construct endNameP [id]
		endName[_ projName]
	construct startNamep[id]
		startName[_ projNameDec]
	construct addToTransTable [id]
		projName[addToTransTableFunc projNameDec startNamep startType projName endNameP endType][addToTransTableFunc2 projNameDec startNamep startType projName endNameP endType]
	

	by
		<'link start=star 'end=en /> n
end function


function addToTransTableFunc2 startProj[id] startElementName[id] startElementType[id] endProj[id] endElementName[id] endElementType[id]
        replace [id]
                trash[id]
        import transTable [repeat transTableEntry]
        deconstruct not * [transTableEntry] transTable
                endProj tls[repeat transline]
	construct idpout [idp]
		startElementName
	construct idpoutr [repeat idp]
		idpout
	import n [newline]
        construct tl [transline]
		endElementName = idpoutr n
	construct tlr [repeat transline]
		tl
	construct tte [transTableEntry]
		endProj tlr
	export transTable
		transTable [. tte]



        by
                trash
end function


function addToTransTableFunc startProj[id] startElementName[id] startElementType[id] endProj[id] endElementName[id] endElementType[id]
	replace [id]
		trash[id]
	import transTable [repeat transTableEntry]
	deconstruct * [transTableEntry] transTable
		endProj tls[repeat transline]
 
	import em[empty]
	construct matchingEntry [transTableEntry]
		endProj tls
	construct tempTransTable [repeat transTableEntry]
		em
	export tempTransTable
	import n [newline]
	construct processedTransTable [repeat transTableEntry]
		transTable[removeMatchTrans matchingEntry] 


	construct idpFinal [repeat idp]
		em
	export tls 
	construct idpProcessed [repeat idp]
		idpFinal[getOthers tls endElementName startElementName] [getOthers2 tls endElementName startElementName]


	construct transLineOut [transline]
		endElementName = idpProcessed n
	
	construct tempTranslines [repeat transline]
		em
	export tempTranslines
	construct removeMatchTransLineTemp [repeat transline]
		tls[removeMatchTransline transLineOut] 
	import tempTranslines 


	construct transTableEntryOut [transTableEntry]
		endProj tempTranslines[. transLineOut]


	import tempTransTable
	export transTable
		tempTransTable [.transTableEntryOut]  %add the new entry
	by
		trash
end function

function getOthers tlsB[repeat transline] name[id] toAdd[id]
	replace [repeat idp]
		in[repeat idp]
	import tls [repeat transline]
	deconstruct * [transline] tls
		name = others[repeat idp] n[newline]

	construct out [idp]
		toAdd+ 
	construct outr [repeat idp]
		out

	by
		outr[. others]
end function


function getOthers2 tlsB[repeat transline] name[id] toAdd[id]
        replace [repeat idp]
                in[repeat idp]
        import tls [repeat transline]
        deconstruct not * [transline] tls
                name = others[repeat idp] n[newline]
        construct out [idp]
                toAdd
        construct outr [repeat idp]
                out
        by
                outr 
end function


function addProjectionChecks %TODO: this.
	replace [program]
		p[program]
	import predicates [repeat predicate]
	import projections [repeat id]
	deconstruct projections
		second[id] first[id] rest[repeat id] %TODO: generalize.
	construct ref [id]
		refines
	construct predName [id]
		second [_ ref] [_ first] 
	construct mav [id]
		MAVO
	import n [newline]
	construct tran [id]
		trans
	construct predOut [predicate]
		pred predName { n
			(mav[_ second] and tran[_ first]) and 'not mav[_ first] n
		} n
	export predicates
		predicates[. predOut]
	import one[number]
	construct num [number]
		9 
	construct runOut [run]
		'run predName for num n
	import runs [repeat run]
	export runs
		runs [. runOut]
	by
		p
end function	

function addCompletePreds
	replace [program]
		p[program]
	import completeTable [repeat completeEntry]
	construct processed [repeat completeEntry]
		completeTable[makeCPreds]
	by
		p
end function

function makeCPreds
	replace [repeat completeEntry]
		cs[repeat completeEntry]
	deconstruct cs
		first[completeEntry] rest[repeat completeEntry]
	construct processedEntry [completeEntry]
		first[makeComplete]
	construct recursiveCall [repeat completeEntry]
		rest[makeCPreds]
	by
		cs
end function

function makeComplete
	replace [completeEntry]
		c[completeEntry]
	import predicates [repeat predicate]
         %projectionName classTypes  dataTypes   propertyTypes supers      owners      types
	deconstruct c
		name[id] classes[repeat id]  dataTypes[repeat id] propertyTypes[repeat id] supers[repeat id] owners[repeat id] types[repeat id]
	construct comp [id]
		complete
	construct predName [id]
		comp[_ name]
	construct em[empty]
	import n [newline]
	construct emRepeatID [repeat idp]
		em
	construct cs [id]
		Class
	construct classCLine[cline]
		cs in em n
	export classCLine
	construct processClasses[repeat id]
		classes[completeClasses1 name][completeClasses2 name][ensureNotEmptyClass]
	import classCLine
	construct prop [id]
		Property
	construct data [id]
		Datatype
	construct propCline [cline]
		prop in em n
	construct dataCline [cline]
		data in em n
	export propCline 
	export dataCline 
	construct processProps [repeat id]
		propertyTypes[completeProps1 name][completeProps2 name][ensureNotEmptyProps]
	import propCline
	construct processData [repeat id]
		dataTypes[completeData1 name][completeData2 name][ensureNotEmptyData]
	import dataCline
	construct Own [id]
		Owner
	construct own [id]
		owner
	construct ownCline [cline]
		Own.own in em n
	export ownCline
	construct processOwns [repeat id]
		owners[completeOwn1 name][completeOwn2 name][ensureNotEmptyOwn]
	import ownCline
	construct repCline [repeat cline]
		classCLine
	construct predOut [predicate]
		pred predName { n repCline[. dataCline][. propCline][. ownCline] } n
	export predicates
		predicates[. predOut]
	by
		c
end function

function ensureNotEmptyClass
	replace [repeat id]
		classes[repeat id]
	import zero [number]
	construct inLen [number]
		zero[length classes]
	where 
		zero[= inLen]
	import classCLine [cline]
	import n [newline]
	construct typeID [id]
		Class
	construct clineOut [cline]
		 // typeID in //Nothing of this type was defined n
	export classCLine
		clineOut
	by
		classes
end function

function ensureNotEmptyData
        replace [repeat id]
                datats[repeat id]
        import zero [number]
        construct inLen [number]
                zero[length datats]
        where 
                zero[= inLen]
        import dataCline [cline]
        import n [newline]
        construct typeID [id]
                Datatype
        construct clineOut [cline]
                 // typeID in //Nothing of this type was defined n 
        export dataCline
                clineOut
        by
                datats
end function


function ensureNotEmptyProps  
        replace [repeat id]
                props[repeat id]
        import zero [number]
        construct inLen [number]
                zero[length props]
        where 
                zero[= inLen]
        import propCline [cline]
        import n [newline]
        construct typeID [id]
                Property
        construct clineOut [cline]
                 // typeID in //Nothing of this type was defined n 
        export propCline
                clineOut
        by
                props
end function

function ensureNotEmptyOwn
        replace [repeat id]
                ownss[repeat id]
        import zero [number]
        construct inLen [number]
                zero[length ownss]
        where
                zero[= inLen]
        import ownCline [cline]
        import n [newline]
        construct typeID [id]
                Owner
	construct typeID2 [id]
		owner
        construct clineOut [cline]
                 // typeID.typeID2 in //Nothing of this type was defined n
        export ownCline
                clineOut
        by
                ownss
end function


function completeProps2 name[id]
        replace [repeat id]
                input[repeat id]
        deconstruct input
                first[id] rest[repeat id]
        import zero [number]
        construct lenRest [number]
                zero[length rest]
        where 
                zero [= lenRest]
        import propCline [cline]
        deconstruct propCline
                cs[id] in is[repeat idp] n[newline]
        construct newIDP [idp]
                first[_ name] 
        construct newIDPrepeat [repeat idp]
                is[. newIDP]
        construct newPropCline [cline]
                cs in newIDPrepeat n
        export propCline
                newPropCline
        construct recursiveCall [repeat id]
                rest[completeProps1 name][completeProps2 name]
        by
                input
end function

function completeData2 name[id]
        replace [repeat id]
                input[repeat id]
        deconstruct input
                first[id] rest[repeat id]
        import zero [number]
        construct lenRest [number]
                zero[length rest]
        where 
                zero [= lenRest]
        import dataCline [cline]
        deconstruct dataCline
                cs[id] in is[repeat idp] n[newline]
        construct newIDP [idp]
                first[_ name]
        construct newIDPrepeat [repeat idp]
                is[. newIDP]
        construct newDataCline [cline]
                cs in newIDPrepeat n
        export dataCline
                newDataCline
        construct recursiveCall [repeat id]
                rest[completeData1 name][completeData2 name]
        by
                input
end function

function completeOwn2 name[id]
        replace [repeat id]
                input[repeat id]
        deconstruct input
                first[id] rest[repeat id]
        import zero [number]
        construct lenRest [number]
                zero[length rest]
        where
                zero [= lenRest]


        import ownCline [cline]
        deconstruct ownCline
                cs[id].cd[id] in is[repeat idp] n[newline]
	construct o [id]
		owner
	construct o2 [id]
		first
        construct newIDP [idp]
                (o2.o) 
        construct newIDPrepeat [repeat idp]
                is[. newIDP]
        construct newOwnCline [cline]
                cs.cd in newIDPrepeat n
        export ownCline
                newOwnCline
        construct recursiveCall [repeat id]
                rest[completeOwn1 name][completeOwn2 name]
        by
                input
end function


function completeOwn1 name[id]
        replace [repeat id]
                input[repeat id]
        deconstruct input
                first[id] rest[repeat id]
        import zero [number]
        construct lenRest [number]
                zero[length rest]
        where not
                zero [= lenRest]
        import ownCline [cline]
        deconstruct ownCline
                c[id].cd[id] in is[repeat idp] n[newline]

	construct o [id]
		owner
        construct newIDP [idp]
                (first.o)+ 
        construct newIDPrepeat [repeat idp]
                is[. newIDP]
        construct newownCline [cline]
                c.cd in newIDPrepeat n
        export ownCline
                newownCline
        construct recursiveCall [repeat id]
                rest[completeOwn1 name][completeOwn2 name]
        by
                input
end function


function completeProps1 name[id]
        replace [repeat id]
                input[repeat id]
        deconstruct input
                first[id] rest[repeat id]
        import zero [number]
        construct lenRest [number]
                zero[length rest]
        where not
                zero [= lenRest]
        import propCline [cline]
        deconstruct propCline
                c[id] in is[repeat idp] n[newline]
        construct newIDP [idp]
                first[_ name]+
        construct newIDPrepeat [repeat idp]
                is[. newIDP]
        construct newPropCline [cline]
                c in newIDPrepeat n
        export propCline
                newPropCline
        construct recursiveCall [repeat id]
                rest[completeProps1 name][completeProps2 name]
        by
                input
end function

function completeClasses1 name[id]
        replace [repeat id]
                input[repeat id]
        deconstruct input
                first[id] rest[repeat id]
        import zero [number]
        construct lenRest [number]
                zero[length rest]
        where not
                zero [= lenRest]
        import classCLine [cline]
        deconstruct classCLine
                c[id] in is[repeat idp] n[newline]
        construct newIDP [idp]
                first[_ name]+
        construct newIDPrepeat [repeat idp]
                is[. newIDP]
        construct newClassCline [cline]
                c in newIDPrepeat n
        export classCLine
                newClassCline
        construct recursiveCall [repeat id]
                rest[completeClasses1 name][completeClasses2 name]
        by
                input
end function


function completeData1 name[id]
	replace [repeat id]
		input[repeat id]
	deconstruct input
		first[id] rest[repeat id]
	import zero [number]
	construct lenRest [number]
		zero[length rest]
	where not
		zero [= lenRest]
	import dataCline [cline]
	deconstruct dataCline
		c[id] in is[repeat idp] n[newline]
	construct newIDP [idp]
		first[_ name]+
	construct newIDPrepeat [repeat idp]
		is[. newIDP]
	construct newDataCline [cline]
		c in newIDPrepeat n
	export dataCline
		newDataCline
	construct recursiveCall [repeat id]
		rest[completeData1 name][completeData2 name]
	by
		input
end function

function completeClasses2 name[id]
        replace [repeat id]
                input[repeat id]
        deconstruct input
                first[id] rest[repeat id]
        import zero [number]
        construct lenRest [number]
                zero[length rest]
        where 
                zero [= lenRest]
        import classCLine [cline]
        deconstruct classCLine
                cs[id] in is[repeat idp] n[newline]
        construct newIDP [idp]
                first[_ name]
        construct newIDPrepeat [repeat idp]
                is[. newIDP]
        construct newClassCline [cline]
                cs in newIDPrepeat n
        export classCLine
                newClassCline
        construct recursiveCall [repeat id]
                rest[completeClasses1 name][completeClasses2 name]
        by
                input
end function



function makeDPLinesBinary compareWith[repeat id] type[id] predName[id]
        replace [id]
                name[id]
        deconstruct compareWith
                first[id] rest[repeat id]
        import predLinesUB [repeat distinctPredLine]
	import zero [number]
	construct restLen [number]
		zero[length rest]
	where
		zero [= restLen]
        construct xvar [id]
                x
	construct qvar [id]
		q
	construct yvar [id]
		y
        import n [newline]
	import disBinProjMap [repeat disBinProjMapEntry]
	deconstruct * [disBinProjMapEntry] disBinProjMap
		projName[id]  predName
construct ow [id]
	owner
        construct predline [distinctPredLine]
                ('all qvar: first '| 'not xvar->yvar in qvar.ow[_ first][_ projName])n
        construct predlineFiltered[distinctPredLine]
                predline[mavoFilterU2][mavoFilterU3]
        export predLinesUB
                predLinesUB[. predlineFiltered]
        construct recursiveCall [id]
                name[makeDPLinesBinary rest type predName][makeDPLinesBinary2 rest type predName]
        by
                name
end function




function makeDPLinesBinary2 compareWith[repeat id] type[id] predName [id]
        replace [id]
                name[id]
        deconstruct compareWith
                first[id] rest[repeat id]
        import predLinesUB [repeat distinctPredLine]
        import zero [number]
        construct restLen [number]
                zero[length rest]
        where not
                zero [= restLen]
        construct xvar [id]
                x
        construct qvar [id]
                q
        construct yvar [id]
                y
        import n [newline]
	import disBinProjMap [repeat disBinProjMapEntry]
        deconstruct * [disBinProjMapEntry] disBinProjMap
                projName[id]  predName

construct ow [id]
	owner
        construct predline [distinctPredLine]
                ('all qvar: first '| 'not xvar->yvar in qvar.ow[_ first][_ projName]) and n
        construct predlineFiltered[distinctPredLine]
                predline[mavoFilterU2][mavoFilterU3]
        export predLinesUB
                predLinesUB[. predlineFiltered]
        construct recursiveCall [id]
               name[makeDPLinesBinary rest type predName][makeDPLinesBinary2 rest type predName]
        by
                name
end function




function generateBinaryDistinctPreds
	replace [program]
		p[program]
	import ownTable [repeat ownEntry]
	construct ownProcessed [repeat ownEntry]
		ownTable[recursivelyCallForOwn ownTable]
	by
		p
end function

function recursivelyCallForOwn copy[repeat ownEntry]
	replace [repeat ownEntry]
		in[repeat ownEntry]
	deconstruct in
		first[ownEntry] rest[repeat ownEntry]
	deconstruct first
		oName[id] elementType[id] iType[id]
	construct processedPred [id]
		oName[generateBinaryDistinct elementType iType copy]
	construct recursiveCall [repeat ownEntry]
		rest[recursivelyCallForOwn copy]
	by
		in
end function

function generateBinaryDistinct elementType[id] iType[id] allOwns[repeat ownEntry]
	replace [id]
		oName[id]
        construct dis [id]
                distinct
        construct predNameD [id]
                dis[_ oName]
	import n[newline]
        import em[empty]
        construct dlines [repeat distinctPredLine]
                em
	construct xvar [id]
		x
	construct yvar [id]
		y
	construct zvar [id]
		z
	construct compareWith [repeat id]
		em
	export compareWith


        import disBinProjMap [repeat disBinProjMapEntry]
        deconstruct * [disBinProjMapEntry] disBinProjMap
                projName[id] predNameD

	import completeTable [repeat completeEntry]

%projectionName classTypes  dataTypes   propertyTypes supers      owners      types
	deconstruct * [completeEntry] completeTable
		projName c[repeat id] d[repeat id] p[repeat id] s[repeat id] owners[repeat id] t[repeat id]

	import ownTableNames [repeat id]

	construct filtered [repeat id]
		owners[filterID2 oName]
	import compareWith

	construct predLinesUB [repeat distinctPredLine]
		em
	export predLinesUB



	construct makeDLines [id]
		oName[makeDPLinesBinary compareWith iType predNameD][makeDPLinesBinary2 compareWith iType predNameD]
	import predLinesUB


construct ow [id]
	owner
        construct predOutDist [predicate]
                pred predNameD[_ projName] { 'all xvar: elementType '| 'all yvar: iType '| 'all zvar:oName[_ projName] '| n (xvar->yvar in zvar.ow[_ oName][_ projName] implies (
                        predLinesUB )) } n
	import projectionPredicateInfo [repeat projPredEntry]
	deconstruct * [projPredEntry] projectionPredicateInfo
		projName calls[repeat nid]
	construct newProjPredTable [repeat projPredEntry]
		em
	construct matchingPPE [projPredEntry]
		projName calls
	export newProjPredTable
	construct predNameFinal [nid]
		predNameD[_ projName] n
	construct tempTabl [repeat projPredEntry]
		projectionPredicateInfo[removeProjMatched matchingPPE]
	import newProjPredTable
construct predNameFinalFiltered [nid]
	predNameFinal[mavoFilterU]
	construct outPPE [projPredEntry]
		projName calls[.predNameFinalFiltered]
	export projectionPredicateInfo
		newProjPredTable[. outPPE]

	import predicates [repeat predicate]
	export predicates
		predicates[. predOutDist]
	by
		oName
end function

function filterID2 toFilter[id]
        replace [repeat id]
                in[repeat id]
        deconstruct in
                first[id] rest[repeat id]
        construct emIDsUpdated [id]
                first[addToPODs toFilter]
        construct recursiveCall [repeat id]
                rest[filterID2 toFilter]
        by
                in
end function



function addToPODs toFilter[id]
        replace [id]
                in[id]
        where not
                in [= toFilter]
        import compareWith [repeat id]
        export compareWith
                compareWith[. in]
        by
                in
end function



%TODO: fix or remove. ----------------------
function addProjPreds
	replace [program]
		p[program]
	import projections [repeat id]
	construct processProjs [repeat id]
		projections[makeProjPred]
	by
		p
end function

function makeProjPred
	replace [repeat id]
		in[repeat id]
	deconstruct in
		first[id] rest[repeat id]
	construct processed [id]
		first[makeSingleProjPred]
	construct recursiveCall [repeat id]
		rest[makeProjPred]
	by
		in
end function

function makeSingleProjPred
	replace [id]
		in[id]
	import allPredCalls [repeat nid]
	import n [newline]
	construct predOut [predicate]
		pred in { n allPredCalls } n
	import predicates [repeat predicate]
	export predicates
		predicates[.predOut] 
	by
		in
end function

%END TODO ---------------------------------


function addTranslationPreds
	replace [program]
		p[program]
	import transTable [repeat transTableEntry]
	construct processTable [repeat transTableEntry]
		transTable[processTT]
	by
		p
end function


function processTT
	replace [repeat transTableEntry]
		in[repeat transTableEntry]

	deconstruct in
		first[transTableEntry] rest[repeat transTableEntry]

	construct processFirst [transTableEntry]
		first[processTTE]
	construct recursiveCall [repeat transTableEntry]
		rest[processTT]
	by
		in
end function

function processTTE
	replace [transTableEntry]
		t[transTableEntry]
	deconstruct t
		name[id] tls[repeat transline]
	construct tran [id]
		trans
	construct predName [id]
		tran[_ name]
	import n [newline]

	import completeTable [repeat completeEntry]
	deconstruct * [completeEntry] completeTable
		name c[repeat id] d[repeat id] p[repeat id] o[repeat id] su[repeat id] tt[repeat id]
	construct aggregatedSigs [repeat id]
		c[. d][. p][. o][. su][. tt]
	construct appendedAggregatedSigs [repeat id]
		aggregatedSigs[append name]

	construct em [empty]
	construct tlsIDs [repeat id]
		em
	export tlsIDs
	construct getIDs [repeat transline]
		tls[getIdsFromTL]
	import tlsIDs 
	construct filteredList [repeat id]
		em
	export filteredList

	construct filterList [repeat id]
		appendedAggregatedSigs[filterListIDs tlsIDs]

	import filteredList


	construct frameTLS [repeat transline]
		em
	export frameTLS
	construct otherTLS [repeat id]
		filteredList[makeTLS]
	import frameTLS

	construct predOut [predicate]
%		pred predName { n tls[. frameTLS] } n %TODO: fix this.
		pred predName { n tls } n
	import predicates [repeat predicate]
	export predicates
		predicates[. predOut]
	by
		t
end function

function makeTLS %input2[repeat id]
	replace [repeat id]
		input[repeat id]
	deconstruct input
		first[id] rest[repeat id]
	%deconstruct input2
	%	second[id] rest2[repeat id]
	construct idpf [idp]
		first
	construct idpfr [repeat idp]
		idpf
	import n [newline]
	construct tlsout[transline]
		first = idpfr n
	import frameTLS [repeat transline]
	export frameTLS
		frameTLS[. tlsout]
	construct recursiveCall [repeat id]
		rest[makeTLS]
		%rest[makeTLS rest2]
	by
		input
end function

function append i[id]
	replace [repeat id]
		input[repeat id]
	deconstruct input
		first[id] rest[repeat id]
	construct outFirst [id]
		first[_ i]
	construct recur [repeat id]
		rest[append i]
	by
		recur[. outFirst]
end function

function filterListIDs checkAgainst[repeat id]
	replace [repeat id]
		in[repeat id]
	deconstruct in 
		first[id] rest[repeat id]
	construct exportIfNecessary [id]
		first[checkAndExport checkAgainst]
	construct recursiveCall [repeat id]
		rest[filterListIDs checkAgainst]
	by
		in
end function


function checkAndExport ca[repeat id]
	replace [id]
		in[id]
	import filteredList [repeat id]
	deconstruct not * [id] filteredList
		in
	construct sMav[id]
		__S
	construct uMav[id]
		__V %__U
	construct mMav[id]
		__M
	construct iMav[id]
		__INC
	where not
		in[grep sMav]
	where not
                in[grep uMav]
	where not
                in[grep mMav]
	where not
                in[grep iMav]
	export filteredList
		filteredList[. in]
	by
		in
end function


function getIdsFromTL
	replace [repeat transline]
		tls[repeat transline]
	deconstruct tls
		in[transline] rest[repeat transline]
	deconstruct in
		name[id] = stuff[repeat idp] n[newline]
	import tlsIDs [repeat id]
	export tlsIDs
		tlsIDs[. name]
	construct recursiveCall [repeat transline]
		rest[getIdsFromTL]
	by
		tls
end function
%OMFG

function removeMatchTrans matchIn [transTableEntry]
        replace [repeat transTableEntry]
                tableIn[repeat transTableEntry]
        deconstruct tableIn
                first[transTableEntry] rest[repeat transTableEntry]
        construct processedEntry [transTableEntry]
                first[removeMatchT matchIn]
        construct recursiveCall [repeat transTableEntry]
                rest[removeMatchTrans matchIn]
        by
                tableIn
end function

function removeMatchT matchIn [transTableEntry]
        replace [transTableEntry]
                c[transTableEntry]

	deconstruct c
		name[id] tls[repeat transline]
%OMG
	deconstruct matchIn
		nameB[id] tlsB[repeat transline]

        where not
		name[= nameB]

        import tempTransTable [repeat transTableEntry]
        export tempTransTable
                tempTransTable[. c]
        by
                c
end function


function removeMatchTransline matchIn [transline]
        replace [repeat transline]
                tableIn[repeat transline]
        deconstruct tableIn
                first[transline] rest[repeat transline]
        construct processedEntry [transline]
                first[removeMatchTL matchIn]
        construct recursiveCall [repeat transline]
                rest[removeMatchTransline matchIn]
        by
                tableIn
end function

function removeMatchTL matchIn [transline]
        replace [transline]
                c[transline]
	deconstruct matchIn
		name[id] = idps[repeat idp] n[newline]
	deconstruct c
		nameB[id] = idpsB[repeat idp] nB[newline]
        where not
                name[= nameB]
        import tempTranslines [repeat transline]
        export tempTranslines
                tempTranslines[. c]
        by
                c
end function

function mavoFilterU
	replace [nid]
		in[nid]
	deconstruct in
		name[id] n[newline]
	construct uMav [id]
		__V %__U
	where
		name[grep uMav]
	construct out [nid]
		// name n
	by
		out
end function



function mavoFilterM
        replace [nid]
                in[nid]
        deconstruct in
                name[id] n[newline]
        construct eMav [id]
                __M
        where
                name[grep eMav]
        construct out [nid]
                // name n
        by
                out
end function

function mavoFilterS
        replace [nid]
                in[nid]
        deconstruct in
                name[id] n[newline]
        construct eMav [id]
                __S
        where
                name[grep eMav]
        construct out [nid]
                // name n
        by
                out
end function


function mavoFilterI
        replace [nid]
                in[nid]
        deconstruct in
                name[id] n[newline]
        construct eMav [id]
                __INC
        where
                name[grep eMav]
        construct out [nid]
                // name n
        by
                out
end function


function mavoFilterU2
	replace [distinctPredLine]
		inp[distinctPredLine]
	deconstruct inp
		('all a[id]:b[id] '| 'not c[id]->d[id] in e[id].f[id]) aa[opt 'and] n[newline]
	construct appended [id]
		a[_ b][_ c][_ d][_ e][_ f]
	construct uMav[id]
		__V %__U
	where
		appended[grep uMav]
	construct out [distinctPredLine]
		// ('all a:b '| 'not c->d in e.f) aa n
	by
		out
end function


function mavoFilterU3
        replace [distinctPredLine]
                inp[distinctPredLine]
        deconstruct inp
		('all a[id]:b[id] '| (c[id] in d[id]) implies ('not e[id] in f[id])) aa[opt 'and] n[newline]
        construct appended [id]
                a[_ b][_ c][_ d][_ e][_ f]
        construct uMav[id]
                __V %__U
        where
                appended[grep uMav]
        construct out [distinctPredLine]
		// ('all a:b '| (c in d) implies ('not e in f)) aa n
        by
                out
end function


function processNodes
	replace[repeat node]
		in[repeat node]
	deconstruct in
		first[node] rest[repeat node]
	construct processedNode [node]
		first[processNode0][processNode1][processNode2][processNode3][processNode4][processNode5][processNode6][processNode7]
	construct recursiveCall [repeat node]
		rest[processNodes]
	by
		in
end function

function processEdges
	replace[repeat edge]
	 	in[repeat edge]
	deconstruct in
		first[edge] rest[repeat edge]
%construct eddebug [edge]
%	  first[print	]
	construct processedEdge[edge]
		first[processEdge0][processEdge1][processEdge2][processEdge3][processEdge4][processEdge5][processEdge6][processEdge7]
	construct recursiveCall[repeat edge]
		rest[processEdges]
	by
		in
end function


function addNodeNameToIndex
	replace[stringlit]
		str[stringlit]
	import nodeIndex [repeat numnode]
	import one [number]
	import zero [number]
	construct two[number]
		one[+ one]
	construct temp [id]
		ERROR
	construct getUnderscore [id]
		a_a
	construct underScore [id]
		getUnderscore[: two two] 
	construct nameid [id]
		temp[unquote str]
	construct lenname [number]
	        one[# nameid]
	construct numberOfNode [id]
		nameid[: two lenname]
	construct lengthTwo [number]
		zero[# numberOfNode]
	construct tempstring [stringlit]
		"ERROR"
	construct indexOfUnderscore [number]
		zero[index nameid underScore][- one][- one]
	construct makeSureNotZero [number]
		indexOfUnderscore[replaceIfZero lengthTwo]
	construct finalNum [id]
		numberOfNode[: zero makeSureNotZero] 
	construct newIndex [numnode]
		finalNum nameid
%		numberOfNode nameid
	export nodeIndex
	       nodeIndex[. newIndex]
	by
		str
end function

function replaceIfZero nTwo [number]
	replace [number]
		input[number]
	import zero [number]
	where
		zero[= input]
	by
		nTwo
end function

function processNode0
	replace[node]
		inn[node]
	deconstruct inn
		<nodes name=nm[stringlit] on[newline] nt[ntype] m[repeat isMay]/> n[newline]
	deconstruct not * [isMay] m
		may="true" nn[opt newline]
	deconstruct not * [isMay] m
		set="true"  nnn[opt newline]
	deconstruct not * [isMay] m
		var="true"  nnnn[opt newline]
	import nodeAnnotations [repeat nodeEntry]
	construct neOut [nodeEntry]
	        nm nm
	export nodeAnnotations
	       nodeAnnotations[. neOut]
	construct nam [stringlit]
		nm  
	construct addToNodeIndex [stringlit]
		nam[addNodeNameToIndex]
	construct no[id]
		Nodes
	construct temp [id]
		ERROR
	construct nameid [id]
		temp[unquote nam]
	import nodelist [repeat id]
	export nodelist
	       nodelist[. nameid]
	construct sigout[sigdef]
		sig nameid in no {} n
	construct exists [id]
		exists
	construct uniq [id]
		unique
	construct var [id]
		x
	construct varTwo [id]
		y
	construct sigPredOutE [sigPred]
		pred exists[_ nameid] { some var : no '| var in nameid } n
	construct predOutE [predicate]
		sigPredOutE
	construct sigPredOutU [sigPred]
		pred uniq[_ nameid] { 'all var, varTwo : no '| (var in nameid and varTwo in nameid) implies var=varTwo} n
	construct predOutU[predicate]
		sigPredOutU

	construct nPredName [nid]
		exists[_ nameid] n
	construct nPredNameU [nid]
		uniq[_ nameid] n

	construct MAVOFilteredU [nid]
		nPredNameU[mavoFilterS]
	construct MAVOFilteredE [nid]
		nPredName[mavoFilterM]

	import finalcalls [repeat nid]
	export finalcalls
	       finalcalls[. MAVOFilteredU][. MAVOFilteredE]

	import predicates[repeat predicate]
	export predicates
	       predicates[. predOutU][. predOutE]
	import signatures [repeat sigdef]
	export signatures
	       signatures[.sigout]


	construct fundecout [fundec]
	       (declare-fun nameid () no) n
	import fundecs [repeat fundec]
	export fundecs
	       fundecs [. fundecout]

	construct adeco [assertdec]
%	      ('assert ('exists ((var nameid)(varTwo no))(= (nameid[_ no] var)(varTwo)))) n
	      ('assert ('exists ((var no))(= var nameid))) n

	construct bdeco [assertdec]
%	      ('assert (forall ((var nameid)(varTwo nameid)) (=> ('not (= var varTwo))('not(= (nameid[_ no] var)(nameid[_ no] varTwo)))))) n
	      ('assert (forall ((var no)(varTwo no))(=> (and(= var nameid)(= varTwo nameid))(= var varTwo)))) n
	construct fadeco [assertdec]
	      adeco[MAVOFilterAssertMay]
	construct fbdeco [assertdec]
	      bdeco[MAVOFilterAssertSet]
	import assertdecs [repeat assertdec]
	export assertdecs
	       assertdecs[. fadeco][. fbdeco]


	construct sss [id]
		s
	construct ttt [id]
		t
	construct dom [id]
		domain

	construct firstsetint [setint]
		set of int: nameid[+ sss][_ dom] = {0} union nameid[_ dom]; n
	construct secondsetint [setint]
		set of int: nameid[+ ttt][_ dom] = {0} union nameid[_ dom]; n	

	
	import setints [repeat setint]
	export setints 
	       setints[. firstsetint][. secondsetint]
%	construct firstvardom [vardom]
%		'var nameid[+ sss][_ dom]: nameid[+ tgt][+ sss]; n
%	construct secondvardom [vardom]
%		'var nameid[+ ttt][_ dom]: nameid[+ tgt][+ ttt]; n
	import vardoms [repeat vardom]
	export vardoms
	       vardoms%[. firstvardom][. secondvardom]
	construct CSPprocessedNode [node]
	       inn[processNodeForCSP]

	by
		inn
end function
function processNode1
	replace[node]
		inn[node]
	deconstruct inn
		<nodes name=nm[stringlit] on[newline] nt[ntype] m[repeat isMay]/> n[newline]
	deconstruct  * [isMay] m
		may="true"  nn[opt newline]
	deconstruct not * [isMay] m
		set="true"  nnn[opt newline]
	deconstruct not * [isMay] m
		var="true"  nnnn[opt newline]
	construct additional [stringlit]
		"__M"
	construct nam [stringlit]
		nm[+ additional]
	import nodeAnnotations [repeat nodeEntry]
	construct neOut [nodeEntry]
	        nm nam
	export nodeAnnotations
	       nodeAnnotations[. neOut]
	construct addToNodeIndex [stringlit]
		nam[addNodeNameToIndex]
	construct no[id]
		Nodes
	construct temp [id]
		ERROR
	construct nameid [id]
		temp[unquote nam]
	import nodelist [repeat id]
	export nodelist
	       nodelist[. nameid]
	construct sigout[sigdef]
		sig nameid in no {} n
	construct exists [id]
		exists
	construct uniq [id]
		unique
	construct var [id]
		x
	construct varTwo [id]
		y
	construct sigPredOutE [sigPred]
		pred exists[_ nameid] { some var : no '| var in nameid } n
	construct predOutE [predicate]
		sigPredOutE
	construct sigPredOutU [sigPred]
		pred uniq[_ nameid] { 'all var, varTwo : no '| (var in nameid and varTwo in nameid) implies var=varTwo} n
	construct predOutU[predicate]
		sigPredOutU

	construct nPredName [nid]
		exists[_ nameid] n
	construct nPredNameU [nid]
		uniq[_ nameid] n

	construct MAVOFilteredU [nid]
		nPredNameU[mavoFilterS]
	construct MAVOFilteredE [nid]
		nPredName[mavoFilterM]

	import finalcalls [repeat nid]
	export finalcalls
	       finalcalls[. MAVOFilteredU][. MAVOFilteredE]

	import predicates[repeat predicate]
	export predicates
	       predicates[. predOutU][. predOutE]
	import signatures [repeat sigdef]
	export signatures
	       signatures[.sigout]


	construct fundecout [fundec]
	       (declare-fun nameid () no) n
	import fundecs [repeat fundec]
	export fundecs
	       fundecs [. fundecout]

	construct adeco [assertdec]
%	      ('assert ('exists ((var nameid)(varTwo no))(= (nameid[_ no] var)(varTwo)))) n
	      ('assert ('exists ((var no))(= var nameid))) n

	construct bdeco [assertdec]
%	      ('assert (forall ((var nameid)(varTwo nameid)) (=> ('not (= var varTwo))('not(= (nameid[_ no] var)(nameid[_ no] varTwo)))))) n
	      ('assert (forall ((var no)(varTwo no))(=> (and(= var nameid)(= varTwo nameid))(= var varTwo)))) n
	construct fadeco [assertdec]
	      adeco[MAVOFilterAssertMay]
	construct fbdeco [assertdec]
	      bdeco[MAVOFilterAssertSet]
	import assertdecs [repeat assertdec]
	export assertdecs
	       assertdecs[. fadeco][. fbdeco]


	construct sss [id]
		s
	construct ttt [id]
		t
	construct dom [id]
		domain

	construct firstsetint [setint]
		set of int: nameid[+ sss][_ dom] = {0} union nameid[_ dom]; n
	construct secondsetint [setint]
		set of int: nameid[+ ttt][_ dom] = {0} union nameid[_ dom]; n	

	
	import setints [repeat setint]
	export setints 
	       setints[. firstsetint][. secondsetint]
%	construct firstvardom [vardom]
%		'var nameid[+ sss][_ dom]: nameid[+ tgt][+ sss]; n
%	construct secondvardom [vardom]
%		'var nameid[+ ttt][_ dom]: nameid[+ tgt][+ ttt]; n
	import vardoms [repeat vardom]
	export vardoms
	       vardoms%[. firstvardom][. secondvardom]
	construct CSPprocessedNode [node]
	       inn[processNodeForCSP]

	by
		inn
end function
function processNode2
	replace[node]
		inn[node]
	deconstruct inn
		<nodes name=nm[stringlit] on[newline] nt[ntype] m[repeat isMay]/> n[newline]
	deconstruct not * [isMay] m
		may="true"  nn[opt newline]
	deconstruct  * [isMay] m
		set="true"  nnn[opt newline]
	deconstruct not * [isMay] m
		var="true"  nnnn[opt newline]
	construct additional [stringlit]
		"__S"
	construct nam [stringlit]
		nm[+ additional]
	import nodeAnnotations [repeat nodeEntry]
	construct neOut [nodeEntry]
	        nm nam
	export nodeAnnotations
	       nodeAnnotations[. neOut]
	construct addToNodeIndex [stringlit]
		nam[addNodeNameToIndex]
	construct no[id]
		Nodes
	construct temp [id]
		ERROR
	construct nameid [id]
		temp[unquote nam]
	import nodelist [repeat id]
	export nodelist
	       nodelist[. nameid]
	construct sigout[sigdef]
		sig nameid in no {} n
	construct exists [id]
		exists
	construct uniq [id]
		unique
	construct var [id]
		x
	construct varTwo [id]
		y
	construct sigPredOutE [sigPred]
		pred exists[_ nameid] { some var : no '| var in nameid } n
	construct predOutE [predicate]
		sigPredOutE
	construct sigPredOutU [sigPred]
		pred uniq[_ nameid] { 'all var, varTwo : no '| (var in nameid and varTwo in nameid) implies var=varTwo} n
	construct predOutU[predicate]
		sigPredOutU

	construct nPredName [nid]
		exists[_ nameid] n
	construct nPredNameU [nid]
		uniq[_ nameid] n

	construct MAVOFilteredU [nid]
		nPredNameU[mavoFilterS]
	construct MAVOFilteredE [nid]
		nPredName[mavoFilterM]

	import finalcalls [repeat nid]
	export finalcalls
	       finalcalls[. MAVOFilteredU][. MAVOFilteredE]

	import predicates[repeat predicate]
	export predicates
	       predicates[. predOutU][. predOutE]
	import signatures [repeat sigdef]
	export signatures
	       signatures[.sigout]


	construct fundecout [fundec]
	       (declare-fun nameid () no) n
	import fundecs [repeat fundec]
	export fundecs
	       fundecs [. fundecout]

	construct adeco [assertdec]
%	      ('assert ('exists ((var nameid)(varTwo no))(= (nameid[_ no] var)(varTwo)))) n
	      ('assert ('exists ((var no))(= var nameid))) n

	construct bdeco [assertdec]
%	      ('assert (forall ((var nameid)(varTwo nameid)) (=> ('not (= var varTwo))('not(= (nameid[_ no] var)(nameid[_ no] varTwo)))))) n
	      ('assert (forall ((var no)(varTwo no))(=> (and(= var nameid)(= varTwo nameid))(= var varTwo)))) n
	construct fadeco [assertdec]
	      adeco[MAVOFilterAssertMay]
	construct fbdeco [assertdec]
	      bdeco[MAVOFilterAssertSet]
	import assertdecs [repeat assertdec]
	export assertdecs
	       assertdecs[. fadeco][. fbdeco]


	construct sss [id]
		s
	construct ttt [id]
		t
	construct dom [id]
		domain

	construct firstsetint [setint]
		set of int: nameid[+ sss][_ dom] = {0} union nameid[_ dom]; n
	construct secondsetint [setint]
		set of int: nameid[+ ttt][_ dom] = {0} union nameid[_ dom]; n	

	
	import setints [repeat setint]
	export setints 
	       setints[. firstsetint][. secondsetint]
%	construct firstvardom [vardom]
%		'var nameid[+ sss][_ dom]: nameid[+ tgt][+ sss]; n
%	construct secondvardom [vardom]
%		'var nameid[+ ttt][_ dom]: nameid[+ tgt][+ ttt]; n
	import vardoms [repeat vardom]
	export vardoms
	       vardoms%[. firstvardom][. secondvardom]
	construct CSPprocessedNode [node]
	       inn[processNodeForCSP]

	by
		inn
end function
function processNode3
	replace[node]
		inn[node]
	deconstruct inn
		<nodes name=nm[stringlit] on[newline] nt[ntype] m[repeat isMay]/> n[newline]
	deconstruct  * [isMay] m
		may="true"  nn[opt newline]
	deconstruct  * [isMay] m
		set="true"  nnn[opt newline]
	deconstruct not * [isMay] m
		var="true"  nnnn[opt newline]
	construct additional [stringlit]
		"__S__M"
	construct nam [stringlit]
		nm[+ additional]
	import nodeAnnotations [repeat nodeEntry]
	construct neOut [nodeEntry]
	        nm nam
	export nodeAnnotations
	       nodeAnnotations[. neOut]
	construct addToNodeIndex [stringlit]
		nam[addNodeNameToIndex]
	construct no[id]
		Nodes
	construct temp [id]
		ERROR
	construct nameid [id]
		temp[unquote nam]
	import nodelist [repeat id]
	export nodelist
	       nodelist[. nameid]
	construct sigout[sigdef]
		sig nameid in no {} n
	construct exists [id]
		exists
	construct uniq [id]
		unique
	construct var [id]
		x
	construct varTwo [id]
		y
	construct sigPredOutE [sigPred]
		pred exists[_ nameid] { some var : no '| var in nameid } n
	construct predOutE [predicate]
		sigPredOutE
	construct sigPredOutU [sigPred]
		pred uniq[_ nameid] { 'all var, varTwo : no '| (var in nameid and varTwo in nameid) implies var=varTwo} n
	construct predOutU[predicate]
		sigPredOutU

	construct nPredName [nid]
		exists[_ nameid] n
	construct nPredNameU [nid]
		uniq[_ nameid] n

	construct MAVOFilteredU [nid]
		nPredNameU[mavoFilterS]
	construct MAVOFilteredE [nid]
		nPredName[mavoFilterM]

	import finalcalls [repeat nid]
	export finalcalls
	       finalcalls[. MAVOFilteredU][. MAVOFilteredE]

	import predicates[repeat predicate]
	export predicates
	       predicates[. predOutU][. predOutE]
	import signatures [repeat sigdef]
	export signatures
	       signatures[.sigout]


	construct fundecout [fundec]
	       (declare-fun nameid () no) n
	import fundecs [repeat fundec]
	export fundecs
	       fundecs [. fundecout]

	construct adeco [assertdec]
%	      ('assert ('exists ((var nameid)(varTwo no))(= (nameid[_ no] var)(varTwo)))) n
	      ('assert ('exists ((var no))(= var nameid))) n

	construct bdeco [assertdec]
%	      ('assert (forall ((var nameid)(varTwo nameid)) (=> ('not (= var varTwo))('not(= (nameid[_ no] var)(nameid[_ no] varTwo)))))) n
	      ('assert (forall ((var no)(varTwo no))(=> (and(= var nameid)(= varTwo nameid))(= var varTwo)))) n
	construct fadeco [assertdec]
	      adeco[MAVOFilterAssertMay]
	construct fbdeco [assertdec]
	      bdeco[MAVOFilterAssertSet]
	import assertdecs [repeat assertdec]
	export assertdecs
	       assertdecs[. fadeco][. fbdeco]


	construct sss [id]
		s
	construct ttt [id]
		t
	construct dom [id]
		domain

	construct firstsetint [setint]
		set of int: nameid[+ sss][_ dom] = {0} union nameid[_ dom]; n
	construct secondsetint [setint]
		set of int: nameid[+ ttt][_ dom] = {0} union nameid[_ dom]; n	

	
	import setints [repeat setint]
	export setints 
	       setints[. firstsetint][. secondsetint]
%	construct firstvardom [vardom]
%		'var nameid[+ sss][_ dom]: nameid[+ tgt][+ sss]; n
%	construct secondvardom [vardom]
%		'var nameid[+ ttt][_ dom]: nameid[+ tgt][+ ttt]; n
	import vardoms [repeat vardom]
	export vardoms
	       vardoms%[. firstvardom][. secondvardom]
	construct CSPprocessedNode [node]
	       inn[processNodeForCSP]

	by
		inn
end function
function processNode4
	replace[node]
		inn[node]
	deconstruct inn
		<nodes name=nm[stringlit] on[newline] nt[ntype] m[repeat isMay]/> n[newline]
	deconstruct not * [isMay] m
		may="true"  nn[opt newline]
	deconstruct not * [isMay] m
		set="true"  nnn[opt newline]
	deconstruct  * [isMay] m
		var="true"  nnnn[opt newline]
	construct additional [stringlit]
		"__V"
	construct nam [stringlit]
		nm[+ additional]
	import nodeAnnotations [repeat nodeEntry]
	construct neOut [nodeEntry]
	        nm nam
	export nodeAnnotations
	       nodeAnnotations[. neOut]
	construct addToNodeIndex [stringlit]
		nam[addNodeNameToIndex]
	construct no[id]
		Nodes
	construct temp [id]
		ERROR
	construct nameid [id]
		temp[unquote nam]
	import nodelist [repeat id]
	export nodelist
	       nodelist[. nameid]
	construct sigout[sigdef]
		sig nameid in no {} n
	construct exists [id]
		exists
	construct uniq [id]
		unique
	construct var [id]
		x
	construct varTwo [id]
		y
	construct sigPredOutE [sigPred]
		pred exists[_ nameid] { some var : no '| var in nameid } n
	construct predOutE [predicate]
		sigPredOutE
	construct sigPredOutU [sigPred]
		pred uniq[_ nameid] { 'all var, varTwo : no '| (var in nameid and varTwo in nameid) implies var=varTwo} n
	construct predOutU[predicate]
		sigPredOutU

	construct nPredName [nid]
		exists[_ nameid] n
	construct nPredNameU [nid]
		uniq[_ nameid] n

	construct MAVOFilteredU [nid]
		nPredNameU[mavoFilterS]
	construct MAVOFilteredE [nid]
		nPredName[mavoFilterM]

	import finalcalls [repeat nid]
	export finalcalls
	       finalcalls[. MAVOFilteredU][. MAVOFilteredE]

	import predicates[repeat predicate]
	export predicates
	       predicates[. predOutU][. predOutE]
	import signatures [repeat sigdef]
	export signatures
	       signatures[.sigout]


	construct fundecout [fundec]
	       (declare-fun nameid () no) n
	import fundecs [repeat fundec]
	export fundecs
	       fundecs [. fundecout]

	construct adeco [assertdec]
%	      ('assert ('exists ((var nameid)(varTwo no))(= (nameid[_ no] var)(varTwo)))) n
	      ('assert ('exists ((var no))(= var nameid))) n

	construct bdeco [assertdec]
%	      ('assert (forall ((var nameid)(varTwo nameid)) (=> ('not (= var varTwo))('not(= (nameid[_ no] var)(nameid[_ no] varTwo)))))) n
	      ('assert (forall ((var no)(varTwo no))(=> (and(= var nameid)(= varTwo nameid))(= var varTwo)))) n
	construct fadeco [assertdec]
	      adeco[MAVOFilterAssertMay]
	construct fbdeco [assertdec]
	      bdeco[MAVOFilterAssertSet]
	import assertdecs [repeat assertdec]
	export assertdecs
	       assertdecs[. fadeco][. fbdeco]


	construct sss [id]
		s
	construct ttt [id]
		t
	construct dom [id]
		domain

	construct firstsetint [setint]
		set of int: nameid[+ sss][_ dom] = {0} union nameid[_ dom]; n
	construct secondsetint [setint]
		set of int: nameid[+ ttt][_ dom] = {0} union nameid[_ dom]; n	

	
	import setints [repeat setint]
	export setints 
	       setints[. firstsetint][. secondsetint]
%	construct firstvardom [vardom]
%		'var nameid[+ sss][_ dom]: nameid[+ tgt][+ sss]; n
%	construct secondvardom [vardom]
%		'var nameid[+ ttt][_ dom]: nameid[+ tgt][+ ttt]; n
	import vardoms [repeat vardom]
	export vardoms
	       vardoms%[. firstvardom][. secondvardom]
	construct CSPprocessedNode [node]
	       inn[processNodeForCSP]

	by
		inn
end function
function processNode5
	replace[node]
		inn[node]
	deconstruct inn
		<nodes name=nm[stringlit] on[newline] nt[ntype] m[repeat isMay]/> n[newline]
	deconstruct  * [isMay] m
		may="true"  nn[opt newline]
	deconstruct not * [isMay] m
		set="true"  nnn[opt newline]
	deconstruct  * [isMay] m
		var="true"  nnnn[opt newline]
	construct additional [stringlit]
		"__M__V"
	construct nam [stringlit]
		nm[+ additional]
	import nodeAnnotations [repeat nodeEntry]
	construct neOut [nodeEntry]
	        nm nam
	export nodeAnnotations
	       nodeAnnotations[. neOut]
	construct addToNodeIndex [stringlit]
		nam[addNodeNameToIndex]
	construct no[id]
		Nodes
	construct temp [id]
		ERROR
	construct nameid [id]
		temp[unquote nam]
	import nodelist [repeat id]
	export nodelist
	       nodelist[. nameid]
	construct sigout[sigdef]
		sig nameid in no {} n
	construct exists [id]
		exists
	construct uniq [id]
		unique
	construct var [id]
		x
	construct varTwo [id]
		y
	construct sigPredOutE [sigPred]
		pred exists[_ nameid] { some var : no '| var in nameid } n
	construct predOutE [predicate]
		sigPredOutE
	construct sigPredOutU [sigPred]
		pred uniq[_ nameid] { 'all var, varTwo : no '| (var in nameid and varTwo in nameid) implies var=varTwo} n
	construct predOutU[predicate]
		sigPredOutU

	construct nPredName [nid]
		exists[_ nameid] n
	construct nPredNameU [nid]
		uniq[_ nameid] n

	construct MAVOFilteredU [nid]
		nPredNameU[mavoFilterS]
	construct MAVOFilteredE [nid]
		nPredName[mavoFilterM]

	import finalcalls [repeat nid]
	export finalcalls
	       finalcalls[. MAVOFilteredU][. MAVOFilteredE]

	import predicates[repeat predicate]
	export predicates
	       predicates[. predOutU][. predOutE]
	import signatures [repeat sigdef]
	export signatures
	       signatures[.sigout]


	construct fundecout [fundec]
	       (declare-fun nameid () no) n
	import fundecs [repeat fundec]
	export fundecs
	       fundecs [. fundecout]

	construct adeco [assertdec]
%	      ('assert ('exists ((var nameid)(varTwo no))(= (nameid[_ no] var)(varTwo)))) n
	      ('assert ('exists ((var no))(= var nameid))) n

	construct bdeco [assertdec]
%	      ('assert (forall ((var nameid)(varTwo nameid)) (=> ('not (= var varTwo))('not(= (nameid[_ no] var)(nameid[_ no] varTwo)))))) n
	      ('assert (forall ((var no)(varTwo no))(=> (and(= var nameid)(= varTwo nameid))(= var varTwo)))) n
	construct fadeco [assertdec]
	      adeco[MAVOFilterAssertMay]
	construct fbdeco [assertdec]
	      bdeco[MAVOFilterAssertSet]
	import assertdecs [repeat assertdec]
	export assertdecs
	       assertdecs[. fadeco][. fbdeco]


	construct sss [id]
		s
	construct ttt [id]
		t
	construct dom [id]
		domain

	construct firstsetint [setint]
		set of int: nameid[+ sss][_ dom] = {0} union nameid[_ dom]; n
	construct secondsetint [setint]
		set of int: nameid[+ ttt][_ dom] = {0} union nameid[_ dom]; n	

	
	import setints [repeat setint]
	export setints 
	       setints[. firstsetint][. secondsetint]
%	construct firstvardom [vardom]
%		'var nameid[+ sss][_ dom]: nameid[+ tgt][+ sss]; n
%	construct secondvardom [vardom]
%		'var nameid[+ ttt][_ dom]: nameid[+ tgt][+ ttt]; n
	import vardoms [repeat vardom]
	export vardoms
	       vardoms%[. firstvardom][. secondvardom]
	construct CSPprocessedNode [node]
	       inn[processNodeForCSP]

	by
		inn
end function
function processNode6
	replace[node]
		inn[node]
	deconstruct inn
		<nodes name=nm[stringlit] on[newline] nt[ntype] m[repeat isMay]/> n[newline]
	deconstruct not * [isMay] m
		may="true"  nn[opt newline]
	deconstruct  * [isMay] m
		set="true"  nnn[opt newline]
	deconstruct  * [isMay] m
		var="true"  nnnn[opt newline]
	construct additional [stringlit]
		"__V__S"
	construct nam [stringlit]
		nm[+ additional]
	import nodeAnnotations [repeat nodeEntry]
	construct neOut [nodeEntry]
	        nm nam
	export nodeAnnotations
	       nodeAnnotations[. neOut]
	construct addToNodeIndex [stringlit]
		nam[addNodeNameToIndex]
	construct no[id]
		Nodes
	construct temp [id]
		ERROR
	construct nameid [id]
		temp[unquote nam]
	import nodelist [repeat id]
	export nodelist
	       nodelist[. nameid]
	construct sigout[sigdef]
		sig nameid in no {} n
	construct exists [id]
		exists
	construct uniq [id]
		unique
	construct var [id]
		x
	construct varTwo [id]
		y
	construct sigPredOutE [sigPred]
		pred exists[_ nameid] { some var : no '| var in nameid } n
	construct predOutE [predicate]
		sigPredOutE
	construct sigPredOutU [sigPred]
		pred uniq[_ nameid] { 'all var, varTwo : no '| (var in nameid and varTwo in nameid) implies var=varTwo} n
	construct predOutU[predicate]
		sigPredOutU

	construct nPredName [nid]
		exists[_ nameid] n
	construct nPredNameU [nid]
		uniq[_ nameid] n

	construct MAVOFilteredU [nid]
		nPredNameU[mavoFilterS]
	construct MAVOFilteredE [nid]
		nPredName[mavoFilterM]

	import finalcalls [repeat nid]
	export finalcalls
	       finalcalls[. MAVOFilteredU][. MAVOFilteredE]

	import predicates[repeat predicate]
	export predicates
	       predicates[. predOutU][. predOutE]
	import signatures [repeat sigdef]
	export signatures
	       signatures[.sigout]


	construct fundecout [fundec]
	       (declare-fun nameid () no) n
	import fundecs [repeat fundec]
	export fundecs
	       fundecs [. fundecout]

	construct adeco [assertdec]
%	      ('assert ('exists ((var nameid)(varTwo no))(= (nameid[_ no] var)(varTwo)))) n
	      ('assert ('exists ((var no))(= var nameid))) n

	construct bdeco [assertdec]
%	      ('assert (forall ((var nameid)(varTwo nameid)) (=> ('not (= var varTwo))('not(= (nameid[_ no] var)(nameid[_ no] varTwo)))))) n
	      ('assert (forall ((var no)(varTwo no))(=> (and(= var nameid)(= varTwo nameid))(= var varTwo)))) n
	construct fadeco [assertdec]
	      adeco[MAVOFilterAssertMay]
	construct fbdeco [assertdec]
	      bdeco[MAVOFilterAssertSet]
	import assertdecs [repeat assertdec]
	export assertdecs
	       assertdecs[. fadeco][. fbdeco]


	construct sss [id]
		s
	construct ttt [id]
		t
	construct dom [id]
		domain

	construct firstsetint [setint]
		set of int: nameid[+ sss][_ dom] = {0} union nameid[_ dom]; n
	construct secondsetint [setint]
		set of int: nameid[+ ttt][_ dom] = {0} union nameid[_ dom]; n	

	
	import setints [repeat setint]
	export setints 
	       setints[. firstsetint][. secondsetint]
%	construct firstvardom [vardom]
%		'var nameid[+ sss][_ dom]: nameid[+ tgt][+ sss]; n
%	construct secondvardom [vardom]
%		'var nameid[+ ttt][_ dom]: nameid[+ tgt][+ ttt]; n
	import vardoms [repeat vardom]
	export vardoms
	       vardoms%[. firstvardom][. secondvardom]
	construct CSPprocessedNode [node]
	       inn[processNodeForCSP]

	by
		inn
end function
function processNode7
	replace[node]
		inn[node]
	deconstruct inn
		<nodes name=nm[stringlit] on[newline] nt[ntype] m[repeat isMay]/> n[newline]
	deconstruct  * [isMay] m
		may="true"  nn[opt newline]
	deconstruct  * [isMay] m
		set="true"  nnn[opt newline]
	deconstruct  * [isMay] m
		var="true"  nnnn[opt newline]
	construct additional [stringlit]
		"__M__S__V"
	construct nam [stringlit]
		nm[+ additional]
	import nodeAnnotations [repeat nodeEntry]
	construct neOut [nodeEntry]
	        nm nam
	export nodeAnnotations
	       nodeAnnotations[. neOut]
	construct addToNodeIndex [stringlit]
		nam[addNodeNameToIndex]
	construct no[id]
		Nodes
	construct temp [id]
		ERROR
	construct nameid [id]
		temp[unquote nam]
	import nodelist [repeat id]
	export nodelist
	       nodelist[. nameid]
	construct sigout[sigdef]
		sig nameid in no {} n
	construct exists [id]
		exists
	construct uniq [id]
		unique
	construct var [id]
		x
	construct varTwo [id]
		y
	construct sigPredOutE [sigPred]
		pred exists[_ nameid] { some var : no '| var in nameid } n
	construct predOutE [predicate]
		sigPredOutE
	construct sigPredOutU [sigPred]
		pred uniq[_ nameid] { 'all var, varTwo : no '| (var in nameid and varTwo in nameid) implies var=varTwo} n
	construct predOutU[predicate]
		sigPredOutU

	construct nPredName [nid]
		exists[_ nameid] n
	construct nPredNameU [nid]
		uniq[_ nameid] n

	construct MAVOFilteredU [nid]
		nPredNameU[mavoFilterS]
	construct MAVOFilteredE [nid]
		nPredName[mavoFilterM]

	import finalcalls [repeat nid]
	export finalcalls
	       finalcalls[. MAVOFilteredU][. MAVOFilteredE]

	import predicates[repeat predicate]
	export predicates
	       predicates[. predOutU][. predOutE]
	import signatures [repeat sigdef]
	export signatures
	       signatures[.sigout]


	construct fundecout [fundec]
	       (declare-fun nameid () no) n
	import fundecs [repeat fundec]
	export fundecs
	       fundecs [. fundecout]

	construct adeco [assertdec]
%	      ('assert ('exists ((var nameid)(varTwo no))(= (nameid[_ no] var)(varTwo)))) n
	      ('assert ('exists ((var no))(= var nameid))) n

	construct bdeco [assertdec]
%	      ('assert (forall ((var nameid)(varTwo nameid)) (=> ('not (= var varTwo))('not(= (nameid[_ no] var)(nameid[_ no] varTwo)))))) n
	      ('assert (forall ((var no)(varTwo no))(=> (and(= var nameid)(= varTwo nameid))(= var varTwo)))) n
	construct fadeco [assertdec]
	      adeco[MAVOFilterAssertMay]
	construct fbdeco [assertdec]
	      bdeco[MAVOFilterAssertSet]
	import assertdecs [repeat assertdec]
	export assertdecs
	       assertdecs[. fadeco][. fbdeco]


	construct sss [id]
		s
	construct ttt [id]
		t
	construct dom [id]
		domain

	construct firstsetint [setint]
		set of int: nameid[+ sss][_ dom] = {0} union nameid[_ dom]; n
	construct secondsetint [setint]
		set of int: nameid[+ ttt][_ dom] = {0} union nameid[_ dom]; n	

	
	import setints [repeat setint]
	export setints 
	       setints[. firstsetint][. secondsetint]
%	construct firstvardom [vardom]
%		'var nameid[+ sss][_ dom]: nameid[+ tgt][+ sss]; n
%	construct secondvardom [vardom]
%		'var nameid[+ ttt][_ dom]: nameid[+ tgt][+ ttt]; n
	import vardoms [repeat vardom]
	export vardoms
	       vardoms%[. firstvardom][. secondvardom]
	construct CSPprocessedNode [node]
	       inn[processNodeForCSP]

	by
		inn
end function

function makeSMTdistinctAsserts
	replace[program]
		input[program]
	import em[empty]
	import nodelist [repeat id]
	construct makeAsserts [repeat id]
		nodelist[makeSMTdistinctAssertOnIDs]
	by
		input
end function

function makeSMTdistinctAssertOnIDs
	replace [repeat id]
	 	 input[repeat id]
	deconstruct input
		 first[id] rest[repeat id]
	by
		 input
end function

function processNodeForCSP
	replace[node]
		input[node]
	deconstruct input
		<nodes name=nam[stringlit] on[newline] nt[ntype] m[repeat isMay]/> n[newline]
	construct dom [id]
		domain
	import nextint [number]
	import one [number]
	construct temp [id]
		ERROR
	construct nameid [id]
		temp[unquote nam]
	construct setintout [setint]
		set of int :  nameid[_ dom] = { nextint }; n
	construct varsetout [varset]
		var set of nameid[_ dom] : nameid; n
	construct cc [cardconstraint]
		constraint card(nameid) = 1; n
	construct ccf [cardconstraint]
		cc[filterMayCSP]
	construct ccTwo [cardconstraint]
		constraint all_nodes'[nextint'] = nameid; n
	export nextint
	       nextint[+ one]
	import setints [repeat setint]
	export setints
	       setints[. setintout]
	import varsets [repeat varset]
	export varsets
	       varsets[. varsetout]
	import cardconstraints [repeat cardconstraint]
	export cardconstraints
	       cardconstraints[. ccf][. ccTwo]
	by
		input
end function

function filterMayCSP
	replace [cardconstraint]
		constraint card(nameid[id]) = 1; n[newline]
	construct mMav[id]
		__M
	where 
		nameid[grep mMav]
	by
		n
end function

function MAVOFilterAssertMay
	replace [assertdec]
	      ('assert ('exists ((var[id] no[id]))(= varb[id] name[id]))) n[newline]
%	 	 ('assert ('exists ((v[id] name[id])(vv[id] type[id]))(= (funname[id] vvv[id])(vvvv[id])))) n[newline]
	construct mMav[id]
		__M
	where 
		name[grep mMav]
	import em [empty]
	by
		n
end function

function MAVOFilterAssertSet
	replace [assertdec]
%	      ('assert (forall ((v[id] name[id])(vv[id] nametoo[id])) (=> ('not (= vvv[id] vvvv[id]))('not(= (funname[id] vvvvv[id])(funnametoo[id] vvvvvv[id])))))) n[newline]
	      ('assert (forall ((var[id] no[id])(varTwo[id] nod[id]))(=> (and(= vara[id] name[id])(=varTwoa[id] nameid[id]))(=vars[id] varTwof[id])))) n[newline]
	construct sMav[id]
		__S
	where 
		name[grep sMav]
	import em [empty]
	by
		n
end function


function processEdge0
	replace[edge]
		input[edge]
	deconstruct input
	        <edges name=nam[stringlit] onnn[newline] type=etype[stringlit] on[newline] im[repeat isMay]  src=s[stringlit] onn[newline] tgt=t[stringlit]  /> n[newline]
	deconstruct not  * [isMay] im
		may="true" n
	deconstruct not * [isMay] im
		set="true" n
	deconstruct not  * [isMay] im
		var="true" n

	import zero [number]
	construct lenSrc [number]
		zero[# s] 
	construct lenTgt [number]
		zero[# t]
	import one [number]
	construct ten [number]
		one[+ one][+ one][+ one][+ one][+ one][+ one][+ one][+ one][+ one]
	construct frontTrimmedSrc [stringlit]
		s[: ten lenSrc]
	construct frontTrimmedTgt [stringlit]
		t[: ten lenTgt]
	construct temp [id]
		ERROR
	construct tlenm [number]
		zero[# frontTrimmedTgt]
	construct trimTgt [stringlit]
	  	frontTrimmedTgt[: one tlenm]
	construct tgtTemp [id]
	  	temp[unparse trimTgt]
	construct seven [number]
	  	ten[- one][- one][- one]
	construct sevenPlusTLenM [number]
	  	seven[+ tlenm][- one]
	construct tgtNumber[id]
	 	tgtTemp[: seven sevenPlusTLenM]

	construct slenm [number]
		zero[# frontTrimmedSrc]
	construct trimSrc [stringlit]
	  	frontTrimmedSrc[: one slenm]
	construct srcTemp [id]
	  	temp[unparse trimSrc]

	construct sevenPlusSLenM [number]
	  	seven[+ slenm][- one]
	construct srcNumber[id]
	 	srcTemp[: seven sevenPlusSLenM]
	import nodeIndex [repeat numnode]
%	deconstruct * [numnode] nodeIndex
%		tgtNumber tgtname[id]
%	deconstruct * [numnode] nodeIndex
%		srcNumber srcname[id]
%TODO: fix this for ICSE	

	construct nameid [id]
		temp[unquote nam] 
	import edgelist [repeat id]
	export edgelist
	       edgelist[. nameid]
%DEBUGGING
construct numbahb [number]
	  zero[+ one]%[print]

import nodeAnnotations [repeat nodeEntry]
deconstruct * [nodeEntry] nodeAnnotations
	 s sa[stringlit]
deconstruct * [nodeEntry] nodeAnnotations
	 t ta[stringlit]

construct srcname [id]
	temp[unquote sa]
construct tgtname [id]
	temp[unquote ta]



	construct makePredicates [id]
	       nameid[makeEdgePredicates srcname tgtname]	
%	construct cspEdgeProcessed [edge]
%	       input[processEdgeForCSP nameid srcname tgtname]

	construct edges [id]
		Edges
	construct sigout[sigdef]
		sig nameid in edges {} n
	import signatures [repeat sigdef]
	export signatures
	       signatures[. sigout]

	construct funcout [fundec]
	       (declare-fun nameid () edges) n
	construct sr [id]
		  'src
	construct tg [id]
		  'tgt
%DEBUGGING		
construct numbah [number]
	  zero[+ one]%[print]

	construct assertOutSrc [assertdec]
	       ('assert (= (sr nameid) srcname)) n
	construct assertOutTgt [assertdec]
	       ('assert (= (tg nameid) tgtname)) n

	import assertdecs [repeat assertdec]
	export assertdecs
	       assertdecs[. assertOutSrc][. assertOutTgt]

	construct newentry [edgemapping]
	       nameid srcname tgtname
	import edgetable [repeat edgemapping]
	export edgetable
	       edgetable[. newentry]

	import fundecs [repeat fundec]
	export fundecs
	       fundecs[. funcout]
	construct mayAssert [id]
	       nameid[makeMayEdgeAssert srcname tgtname][makeSetEdgeAssert srcname tgtname]
	by
	       input
end function
function processEdge1
	replace[edge]
		input[edge]
	deconstruct input
	        <edges name=nm[stringlit] onnn[newline] type=etype[stringlit] on[newline] im[repeat isMay]  src=s[stringlit] onn[newline] tgt=t[stringlit]  /> n[newline]
	deconstruct  * [isMay] im
		may="true" n
	deconstruct  not * [isMay] im
		set="true" n
	deconstruct not * [isMay] im
		var="true" n
	construct additional [stringlit]
		"__M"
	construct nam [stringlit]
		nm[+ additional]

	import zero [number]
	construct lenSrc [number]
		zero[# s] 
	construct lenTgt [number]
		zero[# t]
	import one [number]
	construct ten [number]
		one[+ one][+ one][+ one][+ one][+ one][+ one][+ one][+ one][+ one]
	construct frontTrimmedSrc [stringlit]
		s[: ten lenSrc]
	construct frontTrimmedTgt [stringlit]
		t[: ten lenTgt]
	construct temp [id]
		ERROR
	construct tlenm [number]
		zero[# frontTrimmedTgt]
	construct trimTgt [stringlit]
	  	frontTrimmedTgt[: one tlenm]
	construct tgtTemp [id]
	  	temp[unparse trimTgt]
	construct seven [number]
	  	ten[- one][- one][- one]
	construct sevenPlusTLenM [number]
	  	seven[+ tlenm][- one]
	construct tgtNumber[id]
	 	tgtTemp[: seven sevenPlusTLenM]

	construct slenm [number]
		zero[# frontTrimmedSrc]
	construct trimSrc [stringlit]
	  	frontTrimmedSrc[: one slenm]
	construct srcTemp [id]
	  	temp[unparse trimSrc]

	construct sevenPlusSLenM [number]
	  	seven[+ slenm][- one]
	construct srcNumber[id]
	 	srcTemp[: seven sevenPlusSLenM]
	import nodeIndex [repeat numnode]
%	deconstruct * [numnode] nodeIndex
%		tgtNumber tgtname[id]
%	deconstruct * [numnode] nodeIndex
%		srcNumber srcname[id]
%TODO: fix this for ICSE	

	construct nameid [id]
		temp[unquote nam] 
	import edgelist [repeat id]
	export edgelist
	       edgelist[. nameid]
%DEBUGGING
construct numbahb [number]
	  zero[+ one]%[print]

import nodeAnnotations [repeat nodeEntry]
deconstruct * [nodeEntry] nodeAnnotations
	 s sa[stringlit]
deconstruct * [nodeEntry] nodeAnnotations
	 t ta[stringlit]

construct srcname [id]
	temp[unquote sa]
construct tgtname [id]
	temp[unquote ta]




	construct makePredicates [id]
	       nameid[makeEdgePredicates srcname tgtname]	
%	construct cspEdgeProcessed [edge]
%	       input[processEdgeForCSP nameid srcname tgtname]

	construct edges [id]
		Edges
	construct sigout[sigdef]
		sig nameid in edges {} n
	import signatures [repeat sigdef]
	export signatures
	       signatures[. sigout]

	construct funcout [fundec]
	       (declare-fun nameid () edges) n
	construct sr [id]
		  'src
	construct tg [id]
		  'tgt
%DEBUGGING		
construct numbah [number]
	  zero[+ one]%[print]

	construct assertOutSrc [assertdec]
	       ('assert (= (sr nameid) srcname)) n
	construct assertOutTgt [assertdec]
	       ('assert (= (tg nameid) tgtname)) n

	import assertdecs [repeat assertdec]
	export assertdecs
	       assertdecs[. assertOutSrc][. assertOutTgt]

	construct newentry [edgemapping]
	       nameid srcname tgtname
	import edgetable [repeat edgemapping]
	export edgetable
	       edgetable[. newentry]

	import fundecs [repeat fundec]
	export fundecs
	       fundecs[. funcout]
	construct mayAssert [id]
	       nameid[makeMayEdgeAssert srcname tgtname][makeSetEdgeAssert srcname tgtname]
	by
	       input
end function
function processEdge2
	replace[edge]
		input[edge]
	deconstruct input
	        <edges name=nm[stringlit] onnn[newline] type=etype[stringlit] on[newline] im[repeat isMay]  src=s[stringlit] onn[newline] tgt=t[stringlit]  /> n[newline]
	deconstruct not * [isMay] im
		may="true" n
	deconstruct  * [isMay] im
		set="true" n
	deconstruct not * [isMay] im
		var="true" n
	construct additional [stringlit]
		"__S"
	construct nam [stringlit]
		nm[+ additional]

	import zero [number]
	construct lenSrc [number]
		zero[# s] 
	construct lenTgt [number]
		zero[# t]
	import one [number]
	construct ten [number]
		one[+ one][+ one][+ one][+ one][+ one][+ one][+ one][+ one][+ one]
	construct frontTrimmedSrc [stringlit]
		s[: ten lenSrc]
	construct frontTrimmedTgt [stringlit]
		t[: ten lenTgt]
	construct temp [id]
		ERROR
	construct tlenm [number]
		zero[# frontTrimmedTgt]
	construct trimTgt [stringlit]
	  	frontTrimmedTgt[: one tlenm]
	construct tgtTemp [id]
	  	temp[unparse trimTgt]
	construct seven [number]
	  	ten[- one][- one][- one]
	construct sevenPlusTLenM [number]
	  	seven[+ tlenm][- one]
	construct tgtNumber[id]
	 	tgtTemp[: seven sevenPlusTLenM]

	construct slenm [number]
		zero[# frontTrimmedSrc]
	construct trimSrc [stringlit]
	  	frontTrimmedSrc[: one slenm]
	construct srcTemp [id]
	  	temp[unparse trimSrc]

	construct sevenPlusSLenM [number]
	  	seven[+ slenm][- one]
	construct srcNumber[id]
	 	srcTemp[: seven sevenPlusSLenM]
	import nodeIndex [repeat numnode]
%	deconstruct * [numnode] nodeIndex
%		tgtNumber tgtname[id]
%	deconstruct * [numnode] nodeIndex
%		srcNumber srcname[id]
%TODO: fix this for ICSE	

	construct nameid [id]
		temp[unquote nam] 
	import edgelist [repeat id]
	export edgelist
	       edgelist[. nameid]
%DEBUGGING
construct numbahb [number]
	  zero[+ one]%[print]

import nodeAnnotations [repeat nodeEntry]
deconstruct * [nodeEntry] nodeAnnotations
	 s sa[stringlit]
deconstruct * [nodeEntry] nodeAnnotations
	 t ta[stringlit]

construct srcname [id]
	temp[unquote sa]
construct tgtname [id]
	temp[unquote ta]


	construct makePredicates [id]
	       nameid[makeEdgePredicates srcname tgtname]	
%	construct cspEdgeProcessed [edge]
%	       input[processEdgeForCSP nameid srcname tgtname]

	construct edges [id]
		Edges
	construct sigout[sigdef]
		sig nameid in edges {} n
	import signatures [repeat sigdef]
	export signatures
	       signatures[. sigout]

	construct funcout [fundec]
	       (declare-fun nameid () edges) n
	construct sr [id]
		  'src
	construct tg [id]
		  'tgt
%DEBUGGING		
construct numbah [number]
	  zero[+ one]%[print]

	construct assertOutSrc [assertdec]
	       ('assert (= (sr nameid) srcname)) n
	construct assertOutTgt [assertdec]
	       ('assert (= (tg nameid) tgtname)) n

	import assertdecs [repeat assertdec]
	export assertdecs
	       assertdecs[. assertOutSrc][. assertOutTgt]

	construct newentry [edgemapping]
	       nameid srcname tgtname
	import edgetable [repeat edgemapping]
	export edgetable
	       edgetable[. newentry]

	import fundecs [repeat fundec]
	export fundecs
	       fundecs[. funcout]
	construct mayAssert [id]
	       nameid[makeMayEdgeAssert srcname tgtname][makeSetEdgeAssert srcname tgtname]
	by
	       input
end function
function processEdge3
	replace[edge]
		input[edge]
	deconstruct input
	        <edges name=nm[stringlit] onnn[newline] type=etype[stringlit] on[newline] im[repeat isMay]  src=s[stringlit] onn[newline] tgt=t[stringlit]  /> n[newline]
	deconstruct  * [isMay] im
		may="true" n
	deconstruct  * [isMay] im
		set="true" n
	deconstruct not * [isMay] im
		var="true" n
	construct additional [stringlit]
		"__M__S"
	construct nam [stringlit]
		nm[+ additional]

	import zero [number]
	construct lenSrc [number]
		zero[# s] 
	construct lenTgt [number]
		zero[# t]
	import one [number]
	construct ten [number]
		one[+ one][+ one][+ one][+ one][+ one][+ one][+ one][+ one][+ one]
	construct frontTrimmedSrc [stringlit]
		s[: ten lenSrc]
	construct frontTrimmedTgt [stringlit]
		t[: ten lenTgt]
	construct temp [id]
		ERROR
	construct tlenm [number]
		zero[# frontTrimmedTgt]
	construct trimTgt [stringlit]
	  	frontTrimmedTgt[: one tlenm]
	construct tgtTemp [id]
	  	temp[unparse trimTgt]
	construct seven [number]
	  	ten[- one][- one][- one]
	construct sevenPlusTLenM [number]
	  	seven[+ tlenm][- one]
	construct tgtNumber[id]
	 	tgtTemp[: seven sevenPlusTLenM]

	construct slenm [number]
		zero[# frontTrimmedSrc]
	construct trimSrc [stringlit]
	  	frontTrimmedSrc[: one slenm]
	construct srcTemp [id]
	  	temp[unparse trimSrc]

	construct sevenPlusSLenM [number]
	  	seven[+ slenm][- one]
	construct srcNumber[id]
	 	srcTemp[: seven sevenPlusSLenM]
	import nodeIndex [repeat numnode]
%	deconstruct * [numnode] nodeIndex
%		tgtNumber tgtname[id]
%	deconstruct * [numnode] nodeIndex
%		srcNumber srcname[id]
%TODO: fix this for ICSE	

	construct nameid [id]
		temp[unquote nam] 
	import edgelist [repeat id]
	export edgelist
	       edgelist[. nameid]
%DEBUGGING
construct numbahb [number]
	  zero[+ one]%[print]

import nodeAnnotations [repeat nodeEntry]
deconstruct * [nodeEntry] nodeAnnotations
	 s sa[stringlit]
deconstruct * [nodeEntry] nodeAnnotations
	 t ta[stringlit]

construct srcname [id]
	temp[unquote sa]
construct tgtname [id]
	temp[unquote ta]



	construct makePredicates [id]
	       nameid[makeEdgePredicates srcname tgtname]	
%	construct cspEdgeProcessed [edge]
%	       input[processEdgeForCSP nameid srcname tgtname]

	construct edges [id]
		Edges
	construct sigout[sigdef]
		sig nameid in edges {} n
	import signatures [repeat sigdef]
	export signatures
	       signatures[. sigout]

	construct funcout [fundec]
	       (declare-fun nameid () edges) n
	construct sr [id]
		  'src
	construct tg [id]
		  'tgt
%DEBUGGING		
construct numbah [number]
	  zero[+ one]%[print]

	construct assertOutSrc [assertdec]
	       ('assert (= (sr nameid) srcname)) n
	construct assertOutTgt [assertdec]
	       ('assert (= (tg nameid) tgtname)) n

	import assertdecs [repeat assertdec]
	export assertdecs
	       assertdecs[. assertOutSrc][. assertOutTgt]

	construct newentry [edgemapping]
	       nameid srcname tgtname
	import edgetable [repeat edgemapping]
	export edgetable
	       edgetable[. newentry]

	import fundecs [repeat fundec]
	export fundecs
	       fundecs[. funcout]
	construct mayAssert [id]
	       nameid[makeMayEdgeAssert srcname tgtname][makeSetEdgeAssert srcname tgtname]
	by
	       input
end function
function processEdge4
	replace[edge]
		input[edge]
	deconstruct input
	        <edges name=nm[stringlit] onnn[newline] type=etype[stringlit] on[newline] im[repeat isMay]  src=s[stringlit] onn[newline] tgt=t[stringlit]  /> n[newline]
	deconstruct  not * [isMay] im
		may="true" n
	deconstruct  not * [isMay] im
		set="true" n
	deconstruct  * [isMay] im
		var="true" n
	construct additional [stringlit]
		"__V"
	construct nam [stringlit]
		nm[+ additional]

	import zero [number]
	construct lenSrc [number]
		zero[# s] 
	construct lenTgt [number]
		zero[# t]
	import one [number]
	construct ten [number]
		one[+ one][+ one][+ one][+ one][+ one][+ one][+ one][+ one][+ one]
	construct frontTrimmedSrc [stringlit]
		s[: ten lenSrc]
	construct frontTrimmedTgt [stringlit]
		t[: ten lenTgt]
	construct temp [id]
		ERROR
	construct tlenm [number]
		zero[# frontTrimmedTgt]
	construct trimTgt [stringlit]
	  	frontTrimmedTgt[: one tlenm]
	construct tgtTemp [id]
	  	temp[unparse trimTgt]
	construct seven [number]
	  	ten[- one][- one][- one]
	construct sevenPlusTLenM [number]
	  	seven[+ tlenm][- one]
	construct tgtNumber[id]
	 	tgtTemp[: seven sevenPlusTLenM]

	construct slenm [number]
		zero[# frontTrimmedSrc]
	construct trimSrc [stringlit]
	  	frontTrimmedSrc[: one slenm]
	construct srcTemp [id]
	  	temp[unparse trimSrc]

	construct sevenPlusSLenM [number]
	  	seven[+ slenm][- one]
	construct srcNumber[id]
	 	srcTemp[: seven sevenPlusSLenM]
	import nodeIndex [repeat numnode]
%	deconstruct * [numnode] nodeIndex
%		tgtNumber tgtname[id]
%	deconstruct * [numnode] nodeIndex
%		srcNumber srcname[id]
%TODO: fix this for ICSE	

	construct nameid [id]
		temp[unquote nam] 
	import edgelist [repeat id]
	export edgelist
	       edgelist[. nameid]
%DEBUGGING
construct numbahb [number]
	  zero[+ one]%[print]

import nodeAnnotations [repeat nodeEntry]
deconstruct * [nodeEntry] nodeAnnotations
	 s sa[stringlit]
deconstruct * [nodeEntry] nodeAnnotations
	 t ta[stringlit]

construct srcname [id]
	temp[unquote sa]
construct tgtname [id]
	temp[unquote ta]



	construct makePredicates [id]
	       nameid[makeEdgePredicates srcname tgtname]	
%	construct cspEdgeProcessed [edge]
%	       input[processEdgeForCSP nameid srcname tgtname]

	construct edges [id]
		Edges
	construct sigout[sigdef]
		sig nameid in edges {} n
	import signatures [repeat sigdef]
	export signatures
	       signatures[. sigout]

	construct funcout [fundec]
	       (declare-fun nameid () edges) n
	construct sr [id]
		  'src
	construct tg [id]
		  'tgt
%DEBUGGING		
construct numbah [number]
	  zero[+ one]%[print]

	construct assertOutSrc [assertdec]
	       ('assert (= (sr nameid) srcname)) n
	construct assertOutTgt [assertdec]
	       ('assert (= (tg nameid) tgtname)) n

	import assertdecs [repeat assertdec]
	export assertdecs
	       assertdecs[. assertOutSrc][. assertOutTgt]

	construct newentry [edgemapping]
	       nameid srcname tgtname
	import edgetable [repeat edgemapping]
	export edgetable
	       edgetable[. newentry]

	import fundecs [repeat fundec]
	export fundecs
	       fundecs[. funcout]
	construct mayAssert [id]
	       nameid[makeMayEdgeAssert srcname tgtname][makeSetEdgeAssert srcname tgtname]
	by
	       input
end function
function processEdge5
	replace[edge]
		input[edge]
	deconstruct input
	        <edges name=nm[stringlit] onnn[newline] type=etype[stringlit] on[newline] im[repeat isMay]  src=s[stringlit] onn[newline] tgt=t[stringlit]  /> n[newline]
	deconstruct  * [isMay] im
		may="true" n
	deconstruct not * [isMay] im
		set="true" n
	deconstruct  * [isMay] im
		var="true" n
	construct additional [stringlit]
		"__M__V"
	construct nam [stringlit]
		nm[+ additional]

	import zero [number]
	construct lenSrc [number]
		zero[# s] 
	construct lenTgt [number]
		zero[# t]
	import one [number]
	construct ten [number]
		one[+ one][+ one][+ one][+ one][+ one][+ one][+ one][+ one][+ one]
	construct frontTrimmedSrc [stringlit]
		s[: ten lenSrc]
	construct frontTrimmedTgt [stringlit]
		t[: ten lenTgt]
	construct temp [id]
		ERROR
	construct tlenm [number]
		zero[# frontTrimmedTgt]
	construct trimTgt [stringlit]
	  	frontTrimmedTgt[: one tlenm]
	construct tgtTemp [id]
	  	temp[unparse trimTgt]
	construct seven [number]
	  	ten[- one][- one][- one]
	construct sevenPlusTLenM [number]
	  	seven[+ tlenm][- one]
	construct tgtNumber[id]
	 	tgtTemp[: seven sevenPlusTLenM]

	construct slenm [number]
		zero[# frontTrimmedSrc]
	construct trimSrc [stringlit]
	  	frontTrimmedSrc[: one slenm]
	construct srcTemp [id]
	  	temp[unparse trimSrc]

	construct sevenPlusSLenM [number]
	  	seven[+ slenm][- one]
	construct srcNumber[id]
	 	srcTemp[: seven sevenPlusSLenM]
	import nodeIndex [repeat numnode]
%	deconstruct * [numnode] nodeIndex
%		tgtNumber tgtname[id]
%	deconstruct * [numnode] nodeIndex
%		srcNumber srcname[id]
%TODO: fix this for ICSE	

	construct nameid [id]
		temp[unquote nam] 
	import edgelist [repeat id]
	export edgelist
	       edgelist[. nameid]
%DEBUGGING
construct numbahb [number]
	  zero[+ one]%[print]

import nodeAnnotations [repeat nodeEntry]
deconstruct * [nodeEntry] nodeAnnotations
	 s sa[stringlit]
deconstruct * [nodeEntry] nodeAnnotations
	 t ta[stringlit]

construct srcname [id]
	temp[unquote sa]
construct tgtname [id]
	temp[unquote ta]



	construct makePredicates [id]
	       nameid[makeEdgePredicates srcname tgtname]	
%	construct cspEdgeProcessed [edge]
%	       input[processEdgeForCSP nameid srcname tgtname]

	construct edges [id]
		Edges
	construct sigout[sigdef]
		sig nameid in edges {} n
	import signatures [repeat sigdef]
	export signatures
	       signatures[. sigout]

	construct funcout [fundec]
	       (declare-fun nameid () edges) n
	construct sr [id]
		  'src
	construct tg [id]
		  'tgt
%DEBUGGING		
construct numbah [number]
	  zero[+ one]%[print]

	construct assertOutSrc [assertdec]
	       ('assert (= (sr nameid) srcname)) n
	construct assertOutTgt [assertdec]
	       ('assert (= (tg nameid) tgtname)) n

	import assertdecs [repeat assertdec]
	export assertdecs
	       assertdecs[. assertOutSrc][. assertOutTgt]

	construct newentry [edgemapping]
	       nameid srcname tgtname
	import edgetable [repeat edgemapping]
	export edgetable
	       edgetable[. newentry]

	import fundecs [repeat fundec]
	export fundecs
	       fundecs[. funcout]
	construct mayAssert [id]
	       nameid[makeMayEdgeAssert srcname tgtname][makeSetEdgeAssert srcname tgtname]
	by
	       input
end function
function processEdge6
	replace[edge]
		input[edge]
	deconstruct input
	        <edges name=nm[stringlit] onnn[newline] type=etype[stringlit] on[newline] im[repeat isMay]  src=s[stringlit] onn[newline] tgt=t[stringlit]  /> n[newline]
	deconstruct not * [isMay] im
		may="true" n
	deconstruct  * [isMay] im
		set="true" n
	deconstruct  * [isMay] im
		var="true" n
	construct additional [stringlit]
		"__S__V"
	construct nam [stringlit]
		nm[+ additional]

	import zero [number]
	construct lenSrc [number]
		zero[# s] 
	construct lenTgt [number]
		zero[# t]
	import one [number]
	construct ten [number]
		one[+ one][+ one][+ one][+ one][+ one][+ one][+ one][+ one][+ one]
	construct frontTrimmedSrc [stringlit]
		s[: ten lenSrc]
	construct frontTrimmedTgt [stringlit]
		t[: ten lenTgt]
	construct temp [id]
		ERROR
	construct tlenm [number]
		zero[# frontTrimmedTgt]
	construct trimTgt [stringlit]
	  	frontTrimmedTgt[: one tlenm]
	construct tgtTemp [id]
	  	temp[unparse trimTgt]
	construct seven [number]
	  	ten[- one][- one][- one]
	construct sevenPlusTLenM [number]
	  	seven[+ tlenm][- one]
	construct tgtNumber[id]
	 	tgtTemp[: seven sevenPlusTLenM]

	construct slenm [number]
		zero[# frontTrimmedSrc]
	construct trimSrc [stringlit]
	  	frontTrimmedSrc[: one slenm]
	construct srcTemp [id]
	  	temp[unparse trimSrc]

	construct sevenPlusSLenM [number]
	  	seven[+ slenm][- one]
	construct srcNumber[id]
	 	srcTemp[: seven sevenPlusSLenM]
	import nodeIndex [repeat numnode]
%	deconstruct * [numnode] nodeIndex
%		tgtNumber tgtname[id]
%	deconstruct * [numnode] nodeIndex
%		srcNumber srcname[id]
%TODO: fix this for ICSE	

	construct nameid [id]
		temp[unquote nam] 
	import edgelist [repeat id]
	export edgelist
	       edgelist[. nameid]
%DEBUGGING
construct numbahb [number]
	  zero[+ one]%[print]

import nodeAnnotations [repeat nodeEntry]
deconstruct * [nodeEntry] nodeAnnotations
	 s sa[stringlit]
deconstruct * [nodeEntry] nodeAnnotations
	 t ta[stringlit]

construct srcname [id]
	temp[unquote sa]
construct tgtname [id]
	temp[unquote ta]



	construct makePredicates [id]
	       nameid[makeEdgePredicates srcname tgtname]	
%	construct cspEdgeProcessed [edge]
%	       input[processEdgeForCSP nameid srcname tgtname]

	construct edges [id]
		Edges
	construct sigout[sigdef]
		sig nameid in edges {} n
	import signatures [repeat sigdef]
	export signatures
	       signatures[. sigout]

	construct funcout [fundec]
	       (declare-fun nameid () edges) n
	construct sr [id]
		  'src
	construct tg [id]
		  'tgt
%DEBUGGING		
construct numbah [number]
	  zero[+ one]%[print]

	construct assertOutSrc [assertdec]
	       ('assert (= (sr nameid) srcname)) n
	construct assertOutTgt [assertdec]
	       ('assert (= (tg nameid) tgtname)) n

	import assertdecs [repeat assertdec]
	export assertdecs
	       assertdecs[. assertOutSrc][. assertOutTgt]

	construct newentry [edgemapping]
	       nameid srcname tgtname
	import edgetable [repeat edgemapping]
	export edgetable
	       edgetable[. newentry]

	import fundecs [repeat fundec]
	export fundecs
	       fundecs[. funcout]
	construct mayAssert [id]
	       nameid[makeMayEdgeAssert srcname tgtname][makeSetEdgeAssert srcname tgtname]
	by
	       input
end function
function processEdge7
	replace[edge]
		input[edge]
	deconstruct input
	        <edges name=nm[stringlit] onnn[newline] type=etype[stringlit] on[newline] im[repeat isMay]  src=s[stringlit] onn[newline] tgt=t[stringlit]  /> n[newline]

	deconstruct  * [isMay] im
		may="true" n
	deconstruct  * [isMay] im
		set="true" n
	deconstruct  * [isMay] im
		var="true" n
	construct additional [stringlit]
		"__M__S__V"
	construct nam [stringlit]
		nm[+ additional]

	import zero [number]
	construct lenSrc [number]
		zero[# s] 
	construct lenTgt [number]
		zero[# t]
	import one [number]
	construct ten [number]
		one[+ one][+ one][+ one][+ one][+ one][+ one][+ one][+ one][+ one]
	construct frontTrimmedSrc [stringlit]
		s[: ten lenSrc]
	construct frontTrimmedTgt [stringlit]
		t[: ten lenTgt]
	construct temp [id]
		ERROR
	construct tlenm [number]
		zero[# frontTrimmedTgt]
	construct trimTgt [stringlit]
	  	frontTrimmedTgt[: one tlenm]
	construct tgtTemp [id]
	  	temp[unparse trimTgt]
	construct seven [number]
	  	ten[- one][- one][- one]
	construct sevenPlusTLenM [number]
	  	seven[+ tlenm][- one]
	construct tgtNumber[id]
	 	tgtTemp[: seven sevenPlusTLenM]

	construct slenm [number]
		zero[# frontTrimmedSrc]
	construct trimSrc [stringlit]
	  	frontTrimmedSrc[: one slenm]
	construct srcTemp [id]
	  	temp[unparse trimSrc]

	construct sevenPlusSLenM [number]
	  	seven[+ slenm][- one]
	construct srcNumber[id]
	 	srcTemp[: seven sevenPlusSLenM]
	import nodeIndex [repeat numnode]
%	deconstruct * [numnode] nodeIndex
%		tgtNumber tgtname[id]
%	deconstruct * [numnode] nodeIndex
%		srcNumber srcname[id]
%TODO: fix this for ICSE	

	construct nameid [id]
		temp[unquote nam] 
	import edgelist [repeat id]
	export edgelist
	       edgelist[. nameid]
%DEBUGGING
construct numbahb [number]
	  zero[+ one]%[print]

import nodeAnnotations [repeat nodeEntry]
deconstruct * [nodeEntry] nodeAnnotations
	 s sa[stringlit]
deconstruct * [nodeEntry] nodeAnnotations
	 t ta[stringlit]

construct srcname [id]
	temp[unquote sa]
construct tgtname [id]
	temp[unquote ta]



	construct makePredicates [id]
	       nameid[makeEdgePredicates srcname tgtname]	
%	construct cspEdgeProcessed [edge]
%	       input[processEdgeForCSP nameid srcname tgtname]

	construct edges [id]
		Edges
	construct sigout[sigdef]
		sig nameid in edges {} n
	import signatures [repeat sigdef]
	export signatures
	       signatures[. sigout]

	construct funcout [fundec]
	       (declare-fun nameid () edges) n
	construct sr [id]
		  'src
	construct tg [id]
		  'tgt
%DEBUGGING		
construct numbah [number]
	  zero[+ one]%[print]

	construct assertOutSrc [assertdec]
	       ('assert (= (sr nameid) srcname)) n
	construct assertOutTgt [assertdec]
	       ('assert (= (tg nameid) tgtname)) n

	import assertdecs [repeat assertdec]
	export assertdecs
	       assertdecs[. assertOutSrc][. assertOutTgt]

	construct newentry [edgemapping]
	       nameid srcname tgtname
	import edgetable [repeat edgemapping]
	export edgetable
	       edgetable[. newentry]

	import fundecs [repeat fundec]
	export fundecs
	       fundecs[. funcout]
	construct mayAssert [id]
	       nameid[makeMayEdgeAssert srcname tgtname][makeSetEdgeAssert srcname tgtname]
	by
	       input
end function

function makeSetEdgeAssert src[id] tgt[id]
	replace [id]
		edgeName[id]
	construct evar [id]
		e
	construct evarB [id]
		ee
	construct svar [id]
		s
	construct svarB [id]
		ss
	construct tvar [id]
		t
	construct tvarB [id]
		tt
	construct es [id]
		Edges
	construct funcname[id]
		edgeName[_ es]
	import n [newline]
	construct assertOut [assertdec]

             ('assert (forall ((evar es)(evarB es))(=> (and(= evar edgeName )(= evarB edgeName))(= evar evarB)))) n

% ('assert (forall ((evar edgeName)(svar src)(tvar tgt)(evarB edgeName)(svarB src)(tvarB tgt)) (=> (and ('not(= (evar evarB))) ('not(= (svar svarB))) ('not(= (tvar tvarB)))) ('not (= (funcname svar tvar evar)(funcname svarB tvarB evarB)))))) n
	construct filteredAO [assertdec]
%	       assertOut[MAVOFilterAssertSet2 edgeName]
	       assertOut[MAVOFilterAssertSet]
	import assertdecs [repeat assertdec]
	export assertdecs
	       assertdecs[. filteredAO]
	by
		edgeName
end function




function makeMayEdgeAssert src[id] tgt[id]
	replace [id]
		edgeName[id]
	construct es [id]
		Edges
	construct ns [id]
		Nodes
	construct nvarA [id]
		x
	construct nvarB [id]
		y
	construct evar [id]
		e
	import n [newline]
	construct funcname [id]
		edgeName[_ es]
	construct assertOut [assertdec]
	       ('assert (exists ((nvarA es))(= nvarA edgeName))) n
%		('assert (exists ((nvarA src)(nvarB tgt)(evar es)) (= (funcname nvarA nvarB)(evar)))) n
	construct assertOutFiltered [assertdec]
%		assertOut[MAVOFilterAssertMay2 edgeName]
		assertOut[MAVOFilterAssertMay]
	import assertdecs [repeat assertdec]
	export assertdecs
	        assertdecs [. assertOutFiltered]
	by
		edgeName
end function

function makeLastPred
	replace [program]
		p[program]
	import finalcalls [repeat nid]
	import n [newline]
	construct pout [predicate]
		fact final { n finalcalls } n
	import predicates [repeat predicate]
	export predicates
	       predicates[. pout]
	by
		p
end function

function makeDALines compareWith[repeat id] type[id]
	replace [id]
		name[id]
	deconstruct compareWith
		first[id] rest[repeat id]
	import alines [repeat SMTdistinctline]
	import zero [number]
	construct restLen [number]
		zero[length rest]
	where not
		zero[= restLen]
	construct xvar [id]
		x
	construct nvar [id]
		nn
	import n [newline]
	construct assertline [SMTdistinctline]
%		('not (exists (xvar first)(= (nvar)(first[_ type] xvar))))
      		('not(= xvar first))
        construct assertlineFiltered[SMTdistinctline]
                assertline[mavoFilterAssertV]
	export alines
		alines[. assertlineFiltered]
	construct recursiveCall [id]
		name[makeDALines rest type][makeDALines2 rest type]
	by
		name
end function


function makeDALines2 compareWith[repeat id] type[id] 
        replace [id]
                name[id]
        deconstruct compareWith
                first[id] rest[repeat id]
        import alines [repeat SMTdistinctline]
        import zero [number]
        construct restLen [number]
                zero[length rest]
        where 
                zero[= restLen]
        construct xvar [id]
                x
        import n [newline]
	construct nvar [id]
		nn
        construct assertline [SMTdistinctline]
%		('not (exists (xvar first)(= (nvar)(first[_ type] xvar))))
     	     ('not(= xvar first))
	construct assertlineFiltered[SMTdistinctline]
		assertline[mavoFilterAssertV]
        export alines
                alines[. assertlineFiltered]
        construct recursiveCall [id]
                name[makeDALines rest type][makeDALines2 rest type]
        by                                           
                name
end function

function makeDALinesB compareWith[repeat id] type[id] src[id] tgt[id]
	replace [id]
		name[id]
	deconstruct compareWith
		first[id] rest[repeat id]
	import alinesB [repeat SMTdistinctline]
	import zero [number]
	construct restLen [number]
		zero[length rest]
	where not
		zero[= restLen]
	construct xvar [id]
		x
	construct nvar [id]
		nn
	import n [newline]
	construct assertline [SMTdistinctline]
%		('not (exists (xvar first)(= (nvar)(first[_ type] src tgt xvar))))
      	     ('not(= xvar first))
        construct assertlineFiltered[SMTdistinctline]
                assertline[mavoFilterAssertV2]
	export alinesB
		alinesB[. assertlineFiltered]
	construct recursiveCall [id]
		name[makeDALinesB rest type src tgt][makeDALines2B rest type src tgt]
	by
		name
end function


function makeDALines2B compareWith[repeat id] type[id] src[id] tgt[id]
        replace [id]
                name[id]
        deconstruct compareWith
                first[id] rest[repeat id]
        import alinesB [repeat SMTdistinctline]
        import zero [number]
        construct restLen [number]
                zero[length rest]
        where 
                zero[= restLen]
        construct xvar [id]
                x
        import n [newline]
	construct nvar [id]
		nn
        construct assertline [SMTdistinctline]
%		('not (exists (xvar first)(= (nvar)(first[_ type] src tgt xvar))))
      	     ('not(=xvar first))
	construct assertlineFiltered[SMTdistinctline]
		assertline[mavoFilterAssertV2]
        export alinesB
                alinesB[. assertlineFiltered]
        construct recursiveCall [id]
                name[makeDALinesB rest type src tgt][makeDALines2B rest type src tgt]
        by                                           
                name
end function


function mavoFilterAssertV2
	replace [SMTdistinctline]
		inp[SMTdistinctline]
	deconstruct inp
		('not (exists (xvar[id] first[id])(= (nvar[id])(fun[id] x[id] y[id] xvartwo[id]))))
	construct uMav[id]
		__V
	where
		first[grep uMav]
	import em [empty]
	construct out [SMTdistinctline]
		em
	by
		out
end function

function mavoFilterAssertV
	replace [SMTdistinctline]
		inp[SMTdistinctline]
	deconstruct inp
		('not (exists (xvar[id] first[id])(= (nvar[id])(fun[id] xvartwo[id]))))
	construct uMav[id]
		__V
	where
		first[grep uMav]
	import em [empty]
	construct out [SMTdistinctline]
		em
	by
		out
end function


function MAVOFilterAssertMay2 name[id]
	replace [assertdec]
		in[assertdec]
	construct mMav[id]
		__M
	where 
		name[grep mMav]
	import em [empty]
	import n [newline]
	by
		n
end function


function MAVOFilterAssertSet2 name[id]
	replace [assertdec]
		in[assertdec]
	construct mMav[id]
		__S
	where 
		name[grep mMav]
	import em [empty]
	import n [newline]
	by
		n
end function

function makeEdgePredicates srcname[id] tgtname[id]
	replace [id]
		nameid[id]
	import n [newline]
	construct type [id]
		Edges
	construct ex [id]
		exists
	construct uniq [id]
		unique
	construct var [id]
		x
	construct varTwo [id]
		y
	construct sigPredOutE [sigPred]
		pred ex[_ nameid] { some var : type '| var in nameid } n
	construct predOutE [predicate]
		sigPredOutE
	construct sigPredOutU [sigPred]
		pred uniq[_ nameid] { 'all var, varTwo : type '| (var in nameid and varTwo in nameid) implies var=varTwo} n
	construct predOutU[predicate]
		sigPredOutU

	construct nPredName [nid]
		ex[_ nameid] n
	construct nPredNameU [nid]
		uniq[_ nameid] n

	construct MAVOFilteredU [nid]
		nPredNameU[mavoFilterS]
	construct MAVOFilteredE [nid]
		nPredName[mavoFilterM]

	import finalcalls [repeat nid]
	export finalcalls
	       finalcalls[. MAVOFilteredU][. MAVOFilteredE]

%HERE_____


construct enodes [id]
	  es	    
construct SRC [id]
	  Source
construct Src[id]
	  src
	construct factoutSrc [predicate]
		fact { n 'all enodes : nameid '| enodes.(SRC.Src) in srcname } n
construct TGT [id]
	  Target
construct Tgt[id]
	  tgt
	construct factoutTgt [predicate]
		fact { n 'all enodes : nameid '| enodes.(TGT.Tgt) in tgtname } n
import predicates [repeat predicate]

export predicates
       predicates[. factoutSrc][. factoutTgt]
%TO HERE---------------

	import predicates[repeat predicate]
	export predicates
	       predicates[. predOutU][. predOutE]
	by
	       nameid
end function

function processEdgeForCSP edgename[id] src[id] tgt[id]
	replace [edge]
		input[edge]
	construct sss [id]
		s
	construct ttt [id]
		t
	construct dom [id]
		domain
	import n [newline]
	construct firstsetint [setint]
		set of int: src[+ sss][_ dom] = {0} union src[_ dom]; n
	construct secondsetint [setint]
		set of int: tgt[+ ttt][_ dom] = {0} union tgt[_ dom]; n	
	construct firstvardom [vardom]
		var src[+ sss][_ dom]: src[+ tgt][+ sss]; n
	construct secondvardom [vardom]
		var tgt[+ ttt][_ dom]: src[+ tgt][+ ttt]; n
	construct edgecon [edgeconstraint]
	        constraint (min(card(src),card(tgt))=0 /\ src[+ tgt][+ sss] = 0 /\ src[+ tgt][+ ttt] = 0) \/ (min(card(src),card(tgt))!=0 /\ src[+ tgt][+ sss]!=0 /\ src[+ tgt][+ ttt] !=0); n
	construct edgeconf [edgeconstraint]
		edgecon[filterMayCSPedge edgename src tgt]
	import nextedge [number]
	import one [number]
	construct two[number]
		one[+ one]
	construct ccout [cardconstraint]
		constraint all_edges'[nextedge,one'] = src[+ tgt][+ sss]; n
	construct ccoutB [cardconstraint]
		constraint all_edges'[nextedge,two'] = src[+ tgt][+ ttt]; n
	export nextedge
	       nextedge[+ one]
	import setints [repeat setint]
	export setints
	       setints %[. firstsetint][. secondsetint]
	import vardoms [repeat vardom]
	export vardoms
	       vardoms [. firstvardom][. secondvardom]
	import edgeconstraints [repeat edgeconstraint]
	export edgeconstraints
	       edgeconstraints[. edgeconf]
	import cardconstraints [repeat cardconstraint]
	export cardconstraints
	       cardconstraints[. ccout][. ccoutB]
	by
		input
end function


function filterMayCSPedge edgename[id] src[id] tgt[id]
	replace [edgeconstraint]
		in[edgeconstraint]
	construct mMav[id]
		__M
	where 
		edgename[grep mMav]
	construct ss [id]
		s
	construct tt [id]
		t
	import n [newline]
	construct eco [edgeconstraint]
		constraint(min(card(src),card(tgt))=0 /\ src[+ tgt][+ ss] = 0 /\ src[+ tgt][+ tt] = 0) \/ (min(card(src),card(tgt))!=0); n
	by
		eco
end function

function makeNumList
	replace [number]
		in[number]
	import nextint [number]
	where
		in[< nextint]
	import numbersForHeader [list number]
	export numbersForHeader
	       numbersForHeader[, in]
	import one[number]
	construct next [number]
		in[+ one]
	construct recursiveCall [number]
		next[makeNumList]
	by
		in
end function 	 