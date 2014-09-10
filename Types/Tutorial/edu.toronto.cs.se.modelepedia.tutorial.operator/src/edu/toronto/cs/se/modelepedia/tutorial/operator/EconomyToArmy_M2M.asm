<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="EconomyToArmy_M2M"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="A.__matchEconomy2Army():V"/>
		<constant value="__exec__"/>
		<constant value="Economy2Army"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyEconomy2Army(NTransientLink;):V"/>
		<constant value="__matchEconomy2Army"/>
		<constant value="Economy"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="economy"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="army"/>
		<constant value="Army"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="11:3-18:4"/>
		<constant value="__applyEconomy2Army"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="Gold"/>
		<constant value="J.allInstancesFrom(J):J"/>
		<constant value="J.asSequence():J"/>
		<constant value="J.size():J"/>
		<constant value="J.div(J):J"/>
		<constant value="J.subSequence(JJ):J"/>
		<constant value="4"/>
		<constant value="J.Gold2Unit(J):J"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="units"/>
		<constant value="13:5-13:17"/>
		<constant value="13:35-13:39"/>
		<constant value="13:5-13:40"/>
		<constant value="13:5-13:54"/>
		<constant value="14:6-14:7"/>
		<constant value="14:9-14:21"/>
		<constant value="14:39-14:43"/>
		<constant value="14:9-14:44"/>
		<constant value="14:9-14:52"/>
		<constant value="14:57-14:58"/>
		<constant value="14:9-14:59"/>
		<constant value="13:5-15:6"/>
		<constant value="16:13-16:23"/>
		<constant value="16:34-16:38"/>
		<constant value="16:13-16:39"/>
		<constant value="13:5-17:6"/>
		<constant value="12:4-17:6"/>
		<constant value="gold"/>
		<constant value="link"/>
		<constant value="Gold2Unit"/>
		<constant value="MEconomy!Gold;"/>
		<constant value="unit"/>
		<constant value="Unit"/>
		<constant value="generated"/>
		<constant value="infantry"/>
		<constant value="type"/>
		<constant value="26:12-26:23"/>
		<constant value="26:4-26:23"/>
		<constant value="27:12-27:22"/>
		<constant value="27:4-27:22"/>
		<constant value="25:3-28:4"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<operation name="5">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="7"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="9"/>
			<pcall arg="10"/>
			<dup/>
			<push arg="11"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="12"/>
			<pcall arg="10"/>
			<pcall arg="13"/>
			<set arg="3"/>
			<getasm/>
			<push arg="14"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="15"/>
			<getasm/>
			<pcall arg="16"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="18">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="19"/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<if arg="21"/>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<dup/>
			<call arg="23"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="25"/>
			<goto arg="26"/>
			<pop/>
			<load arg="19"/>
			<goto arg="27"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<iterate/>
			<store arg="29"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<call arg="31"/>
			<enditerate/>
			<call arg="32"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="23" end="27"/>
			<lve slot="0" name="17" begin="0" end="29"/>
			<lve slot="1" name="34" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="35">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="36"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="37"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="6"/>
			<lve slot="1" name="34" begin="0" end="6"/>
			<lve slot="2" name="38" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<pcall arg="40"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="42"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="44"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="0" name="17" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="46"/>
			<push arg="46"/>
			<findme/>
			<push arg="47"/>
			<call arg="48"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="49"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="42"/>
			<pcall arg="50"/>
			<dup/>
			<push arg="51"/>
			<load arg="19"/>
			<pcall arg="52"/>
			<dup/>
			<push arg="53"/>
			<push arg="54"/>
			<push arg="54"/>
			<new/>
			<pcall arg="55"/>
			<pusht/>
			<pcall arg="56"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="57" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="51" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="58">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="59"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="51"/>
			<call arg="60"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="53"/>
			<call arg="61"/>
			<store arg="62"/>
			<load arg="62"/>
			<dup/>
			<getasm/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<push arg="63"/>
			<push arg="46"/>
			<findme/>
			<push arg="47"/>
			<call arg="64"/>
			<call arg="65"/>
			<pushi arg="19"/>
			<push arg="63"/>
			<push arg="46"/>
			<findme/>
			<push arg="47"/>
			<call arg="64"/>
			<call arg="66"/>
			<pushi arg="29"/>
			<call arg="67"/>
			<call arg="68"/>
			<iterate/>
			<store arg="69"/>
			<getasm/>
			<load arg="69"/>
			<call arg="70"/>
			<call arg="71"/>
			<enditerate/>
			<call arg="30"/>
			<set arg="72"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="73" begin="14" end="16"/>
			<lne id="74" begin="17" end="17"/>
			<lne id="75" begin="14" end="18"/>
			<lne id="76" begin="14" end="19"/>
			<lne id="77" begin="20" end="20"/>
			<lne id="78" begin="21" end="23"/>
			<lne id="79" begin="24" end="24"/>
			<lne id="80" begin="21" end="25"/>
			<lne id="81" begin="21" end="26"/>
			<lne id="82" begin="27" end="27"/>
			<lne id="83" begin="21" end="28"/>
			<lne id="84" begin="14" end="29"/>
			<lne id="85" begin="32" end="32"/>
			<lne id="86" begin="33" end="33"/>
			<lne id="87" begin="32" end="34"/>
			<lne id="88" begin="11" end="36"/>
			<lne id="89" begin="9" end="38"/>
			<lne id="57" begin="8" end="39"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="4" name="90" begin="31" end="35"/>
			<lve slot="3" name="53" begin="7" end="39"/>
			<lve slot="2" name="51" begin="3" end="39"/>
			<lve slot="0" name="17" begin="0" end="39"/>
			<lve slot="1" name="91" begin="0" end="39"/>
		</localvariabletable>
	</operation>
	<operation name="92">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="93"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="49"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="92"/>
			<pcall arg="50"/>
			<dup/>
			<push arg="90"/>
			<load arg="19"/>
			<pcall arg="52"/>
			<dup/>
			<push arg="94"/>
			<push arg="95"/>
			<push arg="54"/>
			<new/>
			<dup/>
			<store arg="29"/>
			<pcall arg="55"/>
			<pushf/>
			<pcall arg="56"/>
			<load arg="29"/>
			<dup/>
			<getasm/>
			<push arg="96"/>
			<call arg="30"/>
			<set arg="38"/>
			<dup/>
			<getasm/>
			<push arg="97"/>
			<call arg="30"/>
			<set arg="98"/>
			<pop/>
			<load arg="29"/>
		</code>
		<linenumbertable>
			<lne id="99" begin="25" end="25"/>
			<lne id="100" begin="23" end="27"/>
			<lne id="101" begin="30" end="30"/>
			<lne id="102" begin="28" end="32"/>
			<lne id="103" begin="22" end="33"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="94" begin="18" end="34"/>
			<lve slot="0" name="17" begin="0" end="34"/>
			<lve slot="1" name="90" begin="0" end="34"/>
		</localvariabletable>
	</operation>
</asm>
