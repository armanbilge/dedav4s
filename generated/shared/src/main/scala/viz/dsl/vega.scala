/*
 * Copyright 2023 quafadas
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package viz.dsl.vega

import scala.util.Try
import io.circe.syntax.*
import io.circe.*
import cats.syntax.functor.*

// For serialising string unions
given [A <: Singleton](using A <:< String): Decoder[A] = Decoder.decodeString.emapTry(x => Try(x.asInstanceOf[A]))
given [A <: Singleton](using ev: A <:< String): Encoder[A] = Encoder.encodeString.contramap(ev)

// If a union has a null in, then we'll need this too...
type NullValue = None.type

case class VegaDsl(
    val axes: Option[Seq[Axis]] = None,
    val data: Option[Seq[Data]] = None,
    val encode: Option[VegaEncode] = None,
    val layout: Option[Layout] = None,
    val legends: Option[Seq[Legend]] = None,
    val marks: Option[Seq[Mark]] = None,
    val projections: Option[Seq[Projection]] = None,
    val scales: Option[Seq[Scale]] = None,
    val signals: Option[Seq[Signal]] = None,
    val title: Option[Title] = None,
    val usermeta: Option[Map[String, Option[Json]]] = None,
    val `$schema`: Option[String] = None,
    val autosize: Option[Autosize] = None,
    val background: Option[BackgroundElement] = None,
    val config: Option[Map[String, Option[Json]]] = None,
    val description: Option[String] = None,
    val height: Option[HeightElement] = None,
    val padding: Option[Padding] = None,
    val style: Option[Style] = None,
    val width: Option[HeightElement] = None
) derives Encoder.AsObject,
      Decoder

type Autosize = AutosizeSignalRef | AutosizeEnum
given Decoder[Autosize] =
  List[Decoder[Autosize]](
    Decoder[AutosizeSignalRef].widen,
    Decoder[AutosizeEnum].widen
  ).reduceLeft(_ or _)

given Encoder[Autosize] = Encoder.instance {
  case enc0: AutosizeSignalRef => Encoder.AsObject[AutosizeSignalRef].apply(enc0)
  case enc1: AutosizeEnum      => Encoder.encodeString(enc1)
}

case class AutosizeSignalRef(
    val contains: Option[Contains] = None,
    val resize: Option[Boolean] = None,
    val `type`: Option[AutosizeEnum] = None,
    val signal: Option[String] = None
) derives Encoder.AsObject,
      Decoder

type Contains = "content" | "padding"
type AutosizeEnum = "fit" | "fit-x" | "fit-y" | "none" | "pad"
case class Axis(
    val aria: Option[Boolean] = None,
    val bandPosition: Option[BandPositionUnion] = None,
    val description: Option[String] = None,
    val domain: Option[Boolean] = None,
    val domainCap: Option[DomainCapUnion] = None,
    val domainColor: Option[DomainColorUnion] = None,
    val domainDash: Option[DomainDashUnion] = None,
    val domainDashOffset: Option[BandPositionUnion] = None,
    val domainOpacity: Option[BandPositionUnion] = None,
    val domainWidth: Option[BandPositionUnion] = None,
    val encode: Option[AxeEncode] = None,
    val format: Option[AxeFormat] = None,
    val formatType: Option[FormatTypeUnion] = None,
    val grid: Option[Boolean] = None,
    val gridCap: Option[DomainCapUnion] = None,
    val gridColor: Option[DomainColorUnion] = None,
    val gridDash: Option[DomainDashUnion] = None,
    val gridDashOffset: Option[BandPositionUnion] = None,
    val gridOpacity: Option[BandPositionUnion] = None,
    val gridScale: Option[String] = None,
    val gridWidth: Option[BandPositionUnion] = None,
    val labelAlign: Option[LabelAlignUnion] = None,
    val labelAngle: Option[BandPositionUnion] = None,
    val labelBaseline: Option[LabelBaselineUnion] = None,
    val labelBound: Option[LabelBound] = None,
    val labelColor: Option[DomainColorUnion] = None,
    val labelFlush: Option[LabelBound] = None,
    val labelFlushOffset: Option[HeightElement] = None,
    val labelFont: Option[DomainCapUnion] = None,
    val labelFontSize: Option[BandPositionUnion] = None,
    val labelFontStyle: Option[DomainCapUnion] = None,
    val labelFontWeight: Option[LabelFontWeightUnion] = None,
    val labelLimit: Option[BandPositionUnion] = None,
    val labelLineHeight: Option[BandPositionUnion] = None,
    val labelOffset: Option[BandPositionUnion] = None,
    val labelOpacity: Option[BandPositionUnion] = None,
    val labelOverlap: Option[LabelOverlap] = None,
    val labelPadding: Option[BandPositionUnion] = None,
    val labels: Option[Boolean] = None,
    val labelSeparation: Option[HeightElement] = None,
    val maxExtent: Option[BandPositionUnion] = None,
    val minExtent: Option[BandPositionUnion] = None,
    val offset: Option[BandPositionUnion] = None,
    val orient: AxeOrient,
    val position: Option[BandPositionUnion] = None,
    val scale: String,
    val tickBand: Option[TickBand] = None,
    val tickCap: Option[DomainCapUnion] = None,
    val tickColor: Option[DomainColorUnion] = None,
    val tickCount: Option[TickCount] = None,
    val tickDash: Option[DomainDashUnion] = None,
    val tickDashOffset: Option[BandPositionUnion] = None,
    val tickExtra: Option[TickExtraUnion] = None,
    val tickMinStep: Option[HeightElement] = None,
    val tickOffset: Option[BandPositionUnion] = None,
    val tickOpacity: Option[BandPositionUnion] = None,
    val tickRound: Option[TickRoundUnion] = None,
    val ticks: Option[Boolean] = None,
    val tickSize: Option[BandPositionUnion] = None,
    val tickWidth: Option[BandPositionUnion] = None,
    val title: Option[TextOrSignal] = None,
    val titleAlign: Option[LabelAlignUnion] = None,
    val titleAnchor: Option[TitleAnchorUnion] = None,
    val titleAngle: Option[BandPositionUnion] = None,
    val titleBaseline: Option[LabelBaselineUnion] = None,
    val titleColor: Option[DomainColorUnion] = None,
    val titleFont: Option[DomainCapUnion] = None,
    val titleFontSize: Option[BandPositionUnion] = None,
    val titleFontStyle: Option[DomainCapUnion] = None,
    val titleFontWeight: Option[LabelFontWeightUnion] = None,
    val titleLimit: Option[BandPositionUnion] = None,
    val titleLineHeight: Option[BandPositionUnion] = None,
    val titleOpacity: Option[BandPositionUnion] = None,
    val titlePadding: Option[BandPositionUnion] = None,
    val titleX: Option[BandPositionUnion] = None,
    val titleY: Option[BandPositionUnion] = None,
    val translate: Option[BandPositionUnion] = None,
    val values: Option[ArrayOrSignal] = None,
    val zindex: Option[Double] = None
) derives Encoder.AsObject,
      Decoder

case class BandPositionClass(
    val band: Option[Band] = None,
    val exponent: Option[BandPositionUnion] = None,
    val extra: Option[Boolean] = None,
    val mult: Option[BandPositionUnion] = None,
    val offset: Option[BandPositionUnion] = None,
    val round: Option[Boolean] = None,
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None
) derives Encoder.AsObject,
      Decoder

case class BandPositionElement(
    val test: Option[String] = None,
    val band: Option[Band] = None,
    val exponent: Option[BandPositionUnion] = None,
    val extra: Option[Boolean] = None,
    val mult: Option[BandPositionUnion] = None,
    val offset: Option[BandPositionUnion] = None,
    val round: Option[Boolean] = None,
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None
) derives Encoder.AsObject,
      Decoder

type BandPositionUnion = BandPositionClass | Seq[BandPositionElement] | Double
given Decoder[BandPositionUnion] =
  List[Decoder[BandPositionUnion]](
    Decoder[BandPositionClass].widen,
    Decoder[Seq[BandPositionElement]].widen,
    Decoder[Double].widen
  ).reduceLeft(_ or _)

given Encoder[BandPositionUnion] = Encoder.instance {
  case enc0: BandPositionClass        => Encoder.AsObject[BandPositionClass].apply(enc0)
  case enc1: Seq[BandPositionElement] => Encoder.encodeSeq[BandPositionElement].apply(enc1)
  case enc2: Double                   => Encoder.encodeDouble(enc2)
}

type Band = Boolean | Double
given Decoder[Band] =
  List[Decoder[Band]](
    Decoder[Boolean].widen,
    Decoder[Double].widen
  ).reduceLeft(_ or _)

given Encoder[Band] = Encoder.instance {
  case enc0: Boolean => Encoder.encodeBoolean(enc0)
  case enc1: Double  => Encoder.encodeDouble(enc1)
}

case class PurpleSignalRef(
    val signal: Option[String] = None,
    val datum: Option[Field] = None,
    val group: Option[Field] = None,
    val level: Option[Double] = None,
    val parent: Option[Field] = None
) derives Encoder.AsObject,
      Decoder

type Field = PurpleSignalRef | String
given Decoder[Field] =
  List[Decoder[Field]](
    Decoder[PurpleSignalRef].widen,
    Decoder[String].widen
  ).reduceLeft(_ or _)

given Encoder[Field] = Encoder.instance {
  case enc0: PurpleSignalRef => Encoder.AsObject[PurpleSignalRef].apply(enc0)
  case enc1: String          => Encoder.encodeString(enc1)
}

type DomainCapUnion = DomainCapClass | Seq[DomainCapElement] | String
given Decoder[DomainCapUnion] =
  List[Decoder[DomainCapUnion]](
    Decoder[DomainCapClass].widen,
    Decoder[Seq[DomainCapElement]].widen,
    Decoder[String].widen
  ).reduceLeft(_ or _)

given Encoder[DomainCapUnion] = Encoder.instance {
  case enc0: DomainCapClass        => Encoder.AsObject[DomainCapClass].apply(enc0)
  case enc1: Seq[DomainCapElement] => Encoder.encodeSeq[DomainCapElement].apply(enc1)
  case enc2: String                => Encoder.encodeString(enc2)
}

case class DomainCapElement(
    val test: Option[String] = None,
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

case class DomainCapClass(
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

type DomainColorUnion = Seq[BaseColorValue] | PurpleBaseColorValue | String | NullValue
given Decoder[DomainColorUnion] =
  List[Decoder[DomainColorUnion]](
    Decoder[Seq[BaseColorValue]].widen,
    Decoder[PurpleBaseColorValue].widen,
    Decoder[String].widen,
    Decoder[NullValue].widen
  ).reduceLeft(_ or _)

given Encoder[DomainColorUnion] = Encoder.instance {
  case enc0: Seq[BaseColorValue]  => Encoder.encodeSeq[BaseColorValue].apply(enc0)
  case enc1: PurpleBaseColorValue => Encoder.AsObject[PurpleBaseColorValue].apply(enc1)
  case enc2: String               => Encoder.encodeString(enc2)
  case enc3: NullValue            => Encoder.encodeNone(enc3)
}

case class BaseColorValue(
    val test: Option[String] = None,
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None,
    val count: Option[Double] = None,
    val gradient: Option[Field] = None,
    val start: Option[Seq[Double]] = None,
    val stop: Option[Seq[Double]] = None,
    val color: Option[Color] = None
) derives Encoder.AsObject,
      Decoder

case class Color(
    val b: Option[NumberValue] = None,
    val g: Option[NumberValue] = None,
    val r: Option[NumberValue] = None,
    val h: Option[NumberValue] = None,
    val l: Option[NumberValue] = None,
    val s: Option[NumberValue] = None,
    val a: Option[NumberValue] = None,
    val c: Option[NumberValue] = None
) derives Encoder.AsObject,
      Decoder

type NumberValue = BandPositionClass | Seq[BandPositionElement]
given Decoder[NumberValue] =
  List[Decoder[NumberValue]](
    Decoder[BandPositionClass].widen,
    Decoder[Seq[BandPositionElement]].widen
  ).reduceLeft(_ or _)

given Encoder[NumberValue] = Encoder.instance {
  case enc0: BandPositionClass        => Encoder.AsObject[BandPositionClass].apply(enc0)
  case enc1: Seq[BandPositionElement] => Encoder.encodeSeq[BandPositionElement].apply(enc1)
}

case class PurpleBaseColorValue(
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None,
    val count: Option[Double] = None,
    val gradient: Option[Field] = None,
    val start: Option[Seq[Double]] = None,
    val stop: Option[Seq[Double]] = None,
    val color: Option[Color] = None
) derives Encoder.AsObject,
      Decoder

type DomainDashUnion = DomainDashClass | Seq[Dash]
given Decoder[DomainDashUnion] =
  List[Decoder[DomainDashUnion]](
    Decoder[DomainDashClass].widen,
    Decoder[Seq[Dash]].widen
  ).reduceLeft(_ or _)

given Encoder[DomainDashUnion] = Encoder.instance {
  case enc0: DomainDashClass => Encoder.AsObject[DomainDashClass].apply(enc0)
  case enc1: Seq[Dash]       => Encoder.encodeSeq[Dash].apply(enc1)
}

type Dash = DomainDashElement | Double
given Decoder[Dash] =
  List[Decoder[Dash]](
    Decoder[DomainDashElement].widen,
    Decoder[Double].widen
  ).reduceLeft(_ or _)

given Encoder[Dash] = Encoder.instance {
  case enc0: DomainDashElement => Encoder.AsObject[DomainDashElement].apply(enc0)
  case enc1: Double            => Encoder.encodeDouble(enc1)
}

case class DomainDashElement(
    val test: Option[String] = None,
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

case class DomainDashClass(
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

case class AxeEncode(
    val axis: Option[GuideEncode] = None,
    val domain: Option[GuideEncode] = None,
    val grid: Option[GuideEncode] = None,
    val labels: Option[GuideEncode] = None,
    val ticks: Option[GuideEncode] = None,
    val title: Option[GuideEncode] = None
) derives Encoder.AsObject,
      Decoder

case class GuideEncode(
    val interactive: Option[Boolean] = None,
    val name: Option[String] = None,
    val style: Option[Style] = None
) derives Encoder.AsObject,
      Decoder

type Style = Seq[String] | String
given Decoder[Style] =
  List[Decoder[Style]](
    Decoder[Seq[String]].widen,
    Decoder[String].widen
  ).reduceLeft(_ or _)

given Encoder[Style] = Encoder.instance {
  case enc0: Seq[String] => Encoder.encodeSeq[String].apply(enc0)
  case enc1: String      => Encoder.encodeString(enc1)
}

type AxeFormat = FluffySignalRef | String
given Decoder[AxeFormat] =
  List[Decoder[AxeFormat]](
    Decoder[FluffySignalRef].widen,
    Decoder[String].widen
  ).reduceLeft(_ or _)

given Encoder[AxeFormat] = Encoder.instance {
  case enc0: FluffySignalRef => Encoder.AsObject[FluffySignalRef].apply(enc0)
  case enc1: String          => Encoder.encodeString(enc1)
}

case class FluffySignalRef(
    val date: Option[String] = None,
    val day: Option[String] = None,
    val hours: Option[String] = None,
    val milliseconds: Option[String] = None,
    val minutes: Option[String] = None,
    val month: Option[String] = None,
    val quarter: Option[String] = None,
    val seconds: Option[String] = None,
    val week: Option[String] = None,
    val year: Option[String] = None,
    val signal: Option[String] = None
) derives Encoder.AsObject,
      Decoder

type FormatTypeUnion = FormatTypeEnum | FormatTypeSignalRef
given Decoder[FormatTypeUnion] =
  List[Decoder[FormatTypeUnion]](
    Decoder[FormatTypeEnum].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[FormatTypeUnion] = Encoder.instance {
  case enc0: FormatTypeEnum      => Encoder.encodeString(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
}

case class FormatTypeSignalRef(
    val signal: String
) derives Encoder.AsObject,
      Decoder

type FormatTypeEnum = "number" | "time" | "utc"
type LabelAlignUnion = LabelAlignEnum | LabelAlignClass | Seq[LabelAlignElement]
given Decoder[LabelAlignUnion] =
  List[Decoder[LabelAlignUnion]](
    Decoder[LabelAlignEnum].widen,
    Decoder[LabelAlignClass].widen,
    Decoder[Seq[LabelAlignElement]].widen
  ).reduceLeft(_ or _)

given Encoder[LabelAlignUnion] = Encoder.instance {
  case enc0: LabelAlignEnum         => Encoder.encodeString(enc0)
  case enc1: LabelAlignClass        => Encoder.AsObject[LabelAlignClass].apply(enc1)
  case enc2: Seq[LabelAlignElement] => Encoder.encodeSeq[LabelAlignElement].apply(enc2)
}

case class LabelAlignElement(
    val test: Option[String] = None,
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

case class LabelAlignClass(
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

type LabelAlignEnum = "center" | "left" | "right"
type LabelBaselineUnion = Baseline | LabelBaselineClass | Seq[LabelBaselineElement]
given Decoder[LabelBaselineUnion] =
  List[Decoder[LabelBaselineUnion]](
    Decoder[Baseline].widen,
    Decoder[LabelBaselineClass].widen,
    Decoder[Seq[LabelBaselineElement]].widen
  ).reduceLeft(_ or _)

given Encoder[LabelBaselineUnion] = Encoder.instance {
  case enc0: Baseline                  => Encoder.encodeString(enc0)
  case enc1: LabelBaselineClass        => Encoder.AsObject[LabelBaselineClass].apply(enc1)
  case enc2: Seq[LabelBaselineElement] => Encoder.encodeSeq[LabelBaselineElement].apply(enc2)
}

case class LabelBaselineElement(
    val test: Option[String] = None,
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

case class LabelBaselineClass(
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

type Baseline = "alphabetic" | "bottom" | "line-bottom" | "line-top" | "middle" | "top"
type LabelBound = Boolean | Double | FormatTypeSignalRef
given Decoder[LabelBound] =
  List[Decoder[LabelBound]](
    Decoder[Boolean].widen,
    Decoder[Double].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[LabelBound] = Encoder.instance {
  case enc0: Boolean             => Encoder.encodeBoolean(enc0)
  case enc1: Double              => Encoder.encodeDouble(enc1)
  case enc2: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc2)
}

type HeightElement = Double | FormatTypeSignalRef
given Decoder[HeightElement] =
  List[Decoder[HeightElement]](
    Decoder[Double].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[HeightElement] = Encoder.instance {
  case enc0: Double              => Encoder.encodeDouble(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
}

type LabelFontWeightUnion = Double | FontWeight | Long | LabelFontWeightClass | Seq[LabelFontWeightElement] | NullValue
given Decoder[LabelFontWeightUnion] =
  List[Decoder[LabelFontWeightUnion]](
    Decoder[Double].widen,
    Decoder[FontWeight].widen,
    Decoder[Long].widen,
    Decoder[LabelFontWeightClass].widen,
    Decoder[Seq[LabelFontWeightElement]].widen,
    Decoder[NullValue].widen
  ).reduceLeft(_ or _)

given Encoder[LabelFontWeightUnion] = Encoder.instance {
  case enc0: Double                      => Encoder.encodeDouble(enc0)
  case enc1: FontWeight                  => Encoder.encodeString(enc1)
  case enc2: Long                        => Encoder.encodeLong(enc2)
  case enc3: LabelFontWeightClass        => Encoder.AsObject[LabelFontWeightClass].apply(enc3)
  case enc4: Seq[LabelFontWeightElement] => Encoder.encodeSeq[LabelFontWeightElement].apply(enc4)
  case enc5: NullValue                   => Encoder.encodeNone(enc5)
}

case class LabelFontWeightElement(
    val test: Option[String] = None,
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

case class LabelFontWeightClass(
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

type FontWeight = "100" | "200" | "300" | "400" | "500" | "600" | "700" | "800" | "900" | "bold" | "bolder" |
  "lighter" | "normal"
type LabelOverlap = Boolean | LabelOverlapEnum | FormatTypeSignalRef
given Decoder[LabelOverlap] =
  List[Decoder[LabelOverlap]](
    Decoder[Boolean].widen,
    Decoder[LabelOverlapEnum].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[LabelOverlap] = Encoder.instance {
  case enc0: Boolean             => Encoder.encodeBoolean(enc0)
  case enc1: LabelOverlapEnum    => Encoder.encodeString(enc1)
  case enc2: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc2)
}

type LabelOverlapEnum = "greedy" | "parity"
type AxeOrient = TitleOrientEnum | FormatTypeSignalRef
given Decoder[AxeOrient] =
  List[Decoder[AxeOrient]](
    Decoder[TitleOrientEnum].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[AxeOrient] = Encoder.instance {
  case enc0: TitleOrientEnum     => Encoder.encodeString(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
}

type TitleOrientEnum = "bottom" | "left" | "right" | "top"
type TickBand = TickBandEnum | FormatTypeSignalRef
given Decoder[TickBand] =
  List[Decoder[TickBand]](
    Decoder[TickBandEnum].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[TickBand] = Encoder.instance {
  case enc0: TickBandEnum        => Encoder.encodeString(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
}

type TickBandEnum = "center" | "extent"
type TickCount = Double | TickCountEnum | TickCountSignalRef
given Decoder[TickCount] =
  List[Decoder[TickCount]](
    Decoder[Double].widen,
    Decoder[TickCountEnum].widen,
    Decoder[TickCountSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[TickCount] = Encoder.instance {
  case enc0: Double             => Encoder.encodeDouble(enc0)
  case enc1: TickCountEnum      => Encoder.encodeString(enc1)
  case enc2: TickCountSignalRef => Encoder.AsObject[TickCountSignalRef].apply(enc2)
}

case class TickCountSignalRef(
    val interval: Option[Interval] = None,
    val step: Option[HeightElement] = None,
    val signal: Option[String] = None
) derives Encoder.AsObject,
      Decoder

type Interval = TickCountEnum | FormatTypeSignalRef
given Decoder[Interval] =
  List[Decoder[Interval]](
    Decoder[TickCountEnum].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[Interval] = Encoder.instance {
  case enc0: TickCountEnum       => Encoder.encodeString(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
}

type TickCountEnum = "day" | "hour" | "millisecond" | "minute" | "month" | "second" | "week" | "year"
type TickExtraUnion = Boolean | FormatTypeSignalRef
given Decoder[TickExtraUnion] =
  List[Decoder[TickExtraUnion]](
    Decoder[Boolean].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[TickExtraUnion] = Encoder.instance {
  case enc0: Boolean             => Encoder.encodeBoolean(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
}

type TickRoundUnion = Boolean | TickRoundClass | Seq[TickRoundElement]
given Decoder[TickRoundUnion] =
  List[Decoder[TickRoundUnion]](
    Decoder[Boolean].widen,
    Decoder[TickRoundClass].widen,
    Decoder[Seq[TickRoundElement]].widen
  ).reduceLeft(_ or _)

given Encoder[TickRoundUnion] = Encoder.instance {
  case enc0: Boolean               => Encoder.encodeBoolean(enc0)
  case enc1: TickRoundClass        => Encoder.AsObject[TickRoundClass].apply(enc1)
  case enc2: Seq[TickRoundElement] => Encoder.encodeSeq[TickRoundElement].apply(enc2)
}

case class TickRoundElement(
    val test: Option[String] = None,
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

case class TickRoundClass(
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

type TextOrSignal = FormatTypeSignalRef | Seq[String] | String
given Decoder[TextOrSignal] =
  List[Decoder[TextOrSignal]](
    Decoder[FormatTypeSignalRef].widen,
    Decoder[Seq[String]].widen,
    Decoder[String].widen
  ).reduceLeft(_ or _)

given Encoder[TextOrSignal] = Encoder.instance {
  case enc0: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc0)
  case enc1: Seq[String]         => Encoder.encodeSeq[String].apply(enc1)
  case enc2: String              => Encoder.encodeString(enc2)
}

type TitleAnchorUnion = AnchorValue | Anchor | Seq[TitleAnchorElement] | NullValue
given Decoder[TitleAnchorUnion] =
  List[Decoder[TitleAnchorUnion]](
    Decoder[AnchorValue].widen,
    Decoder[Anchor].widen,
    Decoder[Seq[TitleAnchorElement]].widen,
    Decoder[NullValue].widen
  ).reduceLeft(_ or _)

given Encoder[TitleAnchorUnion] = Encoder.instance {
  case enc0: AnchorValue             => Encoder.AsObject[AnchorValue].apply(enc0)
  case enc1: Anchor                  => Encoder.encodeString(enc1)
  case enc2: Seq[TitleAnchorElement] => Encoder.encodeSeq[TitleAnchorElement].apply(enc2)
  case enc3: NullValue               => Encoder.encodeNone(enc3)
}

case class TitleAnchorElement(
    val test: Option[String] = None,
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

case class AnchorValue(
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

type Anchor = "end" | "middle" | "start"
type ArrayOrSignal = Seq[Option[Json]] | FormatTypeSignalRef
given Decoder[ArrayOrSignal] =
  List[Decoder[ArrayOrSignal]](
    Decoder[Seq[Option[Json]]].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[ArrayOrSignal] = Encoder.instance {
  case enc0: Seq[Option[Json]]   => Encoder.encodeSeq[Option[Json]].apply(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
}

type BackgroundElement = FormatTypeSignalRef | String
given Decoder[BackgroundElement] =
  List[Decoder[BackgroundElement]](
    Decoder[FormatTypeSignalRef].widen,
    Decoder[String].widen
  ).reduceLeft(_ or _)

given Encoder[BackgroundElement] = Encoder.instance {
  case enc0: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc0)
  case enc1: String              => Encoder.encodeString(enc1)
}

case class Data(
    val name: String,
    val on: Option[Seq[OnTrigger]] = None,
    val transform: Option[Seq[Transform]] = None,
    val source: Option[Style] = None,
    val async: Option[TickExtraUnion] = None,
    val format: Option[SignalRef] = None,
    val url: Option[BackgroundElement] = None,
    val values: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

case class SignalRef(
    val parse: Option[ParseUnion] = None,
    val `type`: Option[BackgroundElement] = None,
    val copy: Option[TickExtraUnion] = None,
    val property: Option[BackgroundElement] = None,
    val header: Option[Seq[String]] = None,
    val delimiter: Option[String] = None,
    val feature: Option[BackgroundElement] = None,
    val filter: Option[Filter] = None,
    val mesh: Option[BackgroundElement] = None,
    val signal: Option[String] = None
) derives Encoder.AsObject,
      Decoder

type Filter = "exterior" | "interior"
type ParseUnion = ParseEnum | ParseSignalRef
given Decoder[ParseUnion] =
  List[Decoder[ParseUnion]](
    Decoder[ParseEnum].widen,
    Decoder[ParseSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[ParseUnion] = Encoder.instance {
  case enc0: ParseEnum      => Encoder.encodeString(enc0)
  case enc1: ParseSignalRef => Encoder.AsObject[ParseSignalRef].apply(enc1)
}

case class ParseSignalRef(
    val signal: Option[String] = None
) derives Encoder.AsObject,
      Decoder

type ParseEnum = "auto"
case class OnTrigger(
    val insert: Option[String] = None,
    val modify: Option[String] = None,
    val remove: Option[Remove] = None,
    val toggle: Option[String] = None,
    val trigger: String,
    val values: Option[String] = None
) derives Encoder.AsObject,
      Decoder

type Remove = Boolean | String
given Decoder[Remove] =
  List[Decoder[Remove]](
    Decoder[Boolean].widen,
    Decoder[String].widen
  ).reduceLeft(_ or _)

given Encoder[Remove] = Encoder.instance {
  case enc0: Boolean => Encoder.encodeBoolean(enc0)
  case enc1: String  => Encoder.encodeString(enc1)
}

case class Transform(
    val fields: Option[FieldsUnion] = None,
    val query: Option[ArrayOrSignal] = None,
    val signal: Option[String] = None,
    val `type`: TransformType,
    val filter: Option[Json] = None,
    val ignore: Option[HeightElement] = None,
    val as: Option[TransformAs] = None,
    val orient: Option[TransformOrient] = None,
    val require: Option[FormatTypeSignalRef] = None,
    val shape: Option[ShapeUnion] = None,
    val sourceX: Option[ColorElement] = None,
    val sourceY: Option[ColorElement] = None,
    val targetX: Option[ColorElement] = None,
    val targetY: Option[ColorElement] = None,
    val endAngle: Option[HeightElement] = None,
    val field: Option[ColorElement] = None,
    val sort: Option[SortUnion] = None,
    val startAngle: Option[HeightElement] = None,
    val groupby: Option[GroupbyUnion] = None,
    val offset: Option[TransformOffset] = None,
    val alpha: Option[HeightElement] = None,
    val alphaMin: Option[HeightElement] = None,
    val alphaTarget: Option[HeightElement] = None,
    val forces: Option[Seq[ForceElement]] = None,
    val iterations: Option[HeightElement] = None,
    val restart: Option[TickExtraUnion] = None,
    val static: Option[TickExtraUnion] = None,
    val velocityDecay: Option[HeightElement] = None,
    val bandwidth: Option[StepsUnion] = None,
    val cellSize: Option[HeightElement] = None,
    val count: Option[HeightElement] = None,
    val nice: Option[TickExtraUnion] = None,
    val size: Option[StepsUnion] = None,
    val smooth: Option[TickExtraUnion] = None,
    val thresholds: Option[CenterElement] = None,
    val values: Option[ValuesUnion] = None,
    val weight: Option[ColorElement] = None,
    val x: Option[ColorElement] = None,
    val y: Option[ColorElement] = None,
    val geojson: Option[ColorElement] = None,
    val pointRadius: Option[Radius] = None,
    val projection: Option[String] = None,
    val extent: Option[ArrayOrSignal] = None,
    val extentMajor: Option[ArrayOrSignal] = None,
    val extentMinor: Option[ArrayOrSignal] = None,
    val precision: Option[HeightElement] = None,
    val step: Option[StepsUnion] = None,
    val stepMajor: Option[CenterElement] = None,
    val stepMinor: Option[CenterElement] = None,
    val color: Option[ColorElement] = None,
    val opacity: Option[Radius] = None,
    val resolve: Option[ResolveUnion] = None,
    val levels: Option[HeightElement] = None,
    val scale: Option[Radius] = None,
    val translate: Option[Translate] = None,
    val zero: Option[TickExtraUnion] = None,
    val counts: Option[TickExtraUnion] = None,
    val generate: Option[TickExtraUnion] = None,
    val keys: Option[GroupbyUnion] = None,
    val padding: Option[TransformPadding] = None,
    val radius: Option[ColorElement] = None,
    val round: Option[TickExtraUnion] = None,
    val key: Option[ColorElement] = None,
    val parentKey: Option[ColorElement] = None,
    val method: Option[BackgroundElement] = None,
    val nodeSize: Option[CenterElement] = None,
    val separation: Option[TickExtraUnion] = None,
    val paddingBottom: Option[HeightElement] = None,
    val paddingInner: Option[HeightElement] = None,
    val paddingLeft: Option[HeightElement] = None,
    val paddingOuter: Option[HeightElement] = None,
    val paddingRight: Option[HeightElement] = None,
    val paddingTop: Option[HeightElement] = None,
    val ratio: Option[HeightElement] = None,
    val anchor: Option[AnchorUnion] = None,
    val avoidBaseMark: Option[TickExtraUnion] = None,
    val avoidMarks: Option[AvoidMarks] = None,
    val lineAnchor: Option[BackgroundElement] = None,
    val markIndex: Option[HeightElement] = None,
    val order: Option[HeightElement] = None,
    val params: Option[ParamsUnion] = None,
    val cross: Option[TickExtraUnion] = None,
    val drop: Option[TickExtraUnion] = None,
    val ops: Option[Ops] = None,
    val base: Option[HeightElement] = None,
    val divide: Option[CenterElement] = None,
    val interval: Option[TickExtraUnion] = None,
    val maxbins: Option[HeightElement] = None,
    val minstep: Option[HeightElement] = None,
    val name: Option[BackgroundElement] = None,
    val span: Option[HeightElement] = None,
    val steps: Option[StepsUnion] = None,
    val `case`: Option[CaseUnion] = None,
    val pattern: Option[BackgroundElement] = None,
    val stopwords: Option[BackgroundElement] = None,
    val distribution: Option[Distribution] = None,
    val maxsteps: Option[HeightElement] = None,
    val minsteps: Option[HeightElement] = None,
    val expr: Option[String] = None,
    val index: Option[BackgroundElement] = None,
    val initonly: Option[TickExtraUnion] = None,
    val keyvals: Option[ArrayOrSignal] = None,
    val value: Option[Json] = None,
    val cumulative: Option[TickExtraUnion] = None,
    val default: Option[Json] = None,
    val from: Option[String] = None,
    val limit: Option[HeightElement] = None,
    val op: Option[TransformOp] = None,
    val probs: Option[CenterElement] = None,
    val start: Option[HeightElement] = None,
    val stop: Option[HeightElement] = None,
    val timezone: Option[TimezoneUnion] = None,
    val units: Option[Units] = None,
    val frame: Option[Params] = None,
    val ignorePeers: Option[TickExtraUnion] = None,
    val font: Option[ColorElement] = None,
    val fontSize: Option[Radius] = None,
    val fontSizeRange: Option[FontSizeRange] = None,
    val fontStyle: Option[ColorElement] = None,
    val fontWeight: Option[ColorElement] = None,
    val rotate: Option[Radius] = None,
    val spiral: Option[BackgroundElement] = None,
    val text: Option[ColorElement] = None
) derives Encoder.AsObject,
      Decoder

type AnchorUnion = Double | FormatTypeSignalRef | Seq[BackgroundElement]
given Decoder[AnchorUnion] =
  List[Decoder[AnchorUnion]](
    Decoder[Double].widen,
    Decoder[FormatTypeSignalRef].widen,
    Decoder[Seq[BackgroundElement]].widen
  ).reduceLeft(_ or _)

given Encoder[AnchorUnion] = Encoder.instance {
  case enc0: Double                 => Encoder.encodeDouble(enc0)
  case enc1: FormatTypeSignalRef    => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
  case enc2: Seq[BackgroundElement] => Encoder.encodeSeq[BackgroundElement].apply(enc2)
}

type TransformAs = FormatTypeSignalRef | String | Seq[AElement] | NullValue
given Decoder[TransformAs] =
  List[Decoder[TransformAs]](
    Decoder[FormatTypeSignalRef].widen,
    Decoder[String].widen,
    Decoder[Seq[AElement]].widen,
    Decoder[NullValue].widen
  ).reduceLeft(_ or _)

given Encoder[TransformAs] = Encoder.instance {
  case enc0: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc0)
  case enc1: String              => Encoder.encodeString(enc1)
  case enc2: Seq[AElement]       => Encoder.encodeSeq[AElement].apply(enc2)
  case enc3: NullValue           => Encoder.encodeNone(enc3)
}

type AElement = FormatTypeSignalRef | String | NullValue
given Decoder[AElement] =
  List[Decoder[AElement]](
    Decoder[FormatTypeSignalRef].widen,
    Decoder[String].widen,
    Decoder[NullValue].widen
  ).reduceLeft(_ or _)

given Encoder[AElement] = Encoder.instance {
  case enc0: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc0)
  case enc1: String              => Encoder.encodeString(enc1)
  case enc2: NullValue           => Encoder.encodeNone(enc2)
}

type AvoidMarks = FormatTypeSignalRef | Seq[String]
given Decoder[AvoidMarks] =
  List[Decoder[AvoidMarks]](
    Decoder[FormatTypeSignalRef].widen,
    Decoder[Seq[String]].widen
  ).reduceLeft(_ or _)

given Encoder[AvoidMarks] = Encoder.instance {
  case enc0: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc0)
  case enc1: Seq[String]         => Encoder.encodeSeq[String].apply(enc1)
}

type StepsUnion = Double | FormatTypeSignalRef | Seq[HeightElement]
given Decoder[StepsUnion] =
  List[Decoder[StepsUnion]](
    Decoder[Double].widen,
    Decoder[FormatTypeSignalRef].widen,
    Decoder[Seq[HeightElement]].widen
  ).reduceLeft(_ or _)

given Encoder[StepsUnion] = Encoder.instance {
  case enc0: Double              => Encoder.encodeDouble(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
  case enc2: Seq[HeightElement]  => Encoder.encodeSeq[HeightElement].apply(enc2)
}

type ColorElement = ColorSignalRef | String
given Decoder[ColorElement] =
  List[Decoder[ColorElement]](
    Decoder[ColorSignalRef].widen,
    Decoder[String].widen
  ).reduceLeft(_ or _)

given Encoder[ColorElement] = Encoder.instance {
  case enc0: ColorSignalRef => Encoder.AsObject[ColorSignalRef].apply(enc0)
  case enc1: String         => Encoder.encodeString(enc1)
}

case class ColorSignalRef(
    val signal: Option[String] = None,
    val as: Option[String] = None,
    val field: Option[String] = None,
    val expr: Option[String] = None
) derives Encoder.AsObject,
      Decoder

case class Distribution(
    val function: Function,
    val mean: Option[HeightElement] = None,
    val stdev: Option[HeightElement] = None,
    val max: Option[HeightElement] = None,
    val min: Option[HeightElement] = None,
    val bandwidth: Option[HeightElement] = None,
    val field: Option[ColorElement] = None,
    val from: Option[String] = None,
    val distributions: Option[ArrayOrSignal] = None,
    val weights: Option[CenterElement] = None
) derives Encoder.AsObject,
      Decoder

type Function = "kde" | "lognormal" | "mixture" | "normal" | "uniform"
type CenterElement = FormatTypeSignalRef | Seq[HeightElement]
given Decoder[CenterElement] =
  List[Decoder[CenterElement]](
    Decoder[FormatTypeSignalRef].widen,
    Decoder[Seq[HeightElement]].widen
  ).reduceLeft(_ or _)

given Encoder[CenterElement] = Encoder.instance {
  case enc0: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc0)
  case enc1: Seq[HeightElement]  => Encoder.encodeSeq[HeightElement].apply(enc1)
}

type FieldsUnion = FormatTypeSignalRef | Seq[FieldsField]
given Decoder[FieldsUnion] =
  List[Decoder[FieldsUnion]](
    Decoder[FormatTypeSignalRef].widen,
    Decoder[Seq[FieldsField]].widen
  ).reduceLeft(_ or _)

given Encoder[FieldsUnion] = Encoder.instance {
  case enc0: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc0)
  case enc1: Seq[FieldsField]    => Encoder.encodeSeq[FieldsField].apply(enc1)
}

type FieldsField = String | TentacledSignalRef | NullValue
given Decoder[FieldsField] =
  List[Decoder[FieldsField]](
    Decoder[String].widen,
    Decoder[TentacledSignalRef].widen,
    Decoder[NullValue].widen
  ).reduceLeft(_ or _)

given Encoder[FieldsField] = Encoder.instance {
  case enc0: String             => Encoder.encodeString(enc0)
  case enc1: TentacledSignalRef => Encoder.AsObject[TentacledSignalRef].apply(enc1)
  case enc2: NullValue          => Encoder.encodeNone(enc2)
}

case class TentacledSignalRef(
    val signal: Option[String] = None,
    val as: Option[String] = None,
    val field: Option[String] = None,
    val expr: Option[String] = None
) derives Encoder.AsObject,
      Decoder

type Radius = Double | FontSizeSignalRef
given Decoder[Radius] =
  List[Decoder[Radius]](
    Decoder[Double].widen,
    Decoder[FontSizeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[Radius] = Encoder.instance {
  case enc0: Double            => Encoder.encodeDouble(enc0)
  case enc1: FontSizeSignalRef => Encoder.AsObject[FontSizeSignalRef].apply(enc1)
}

case class FontSizeSignalRef(
    val signal: Option[String] = None,
    val as: Option[String] = None,
    val expr: Option[String] = None,
    val field: Option[String] = None
) derives Encoder.AsObject,
      Decoder

type FontSizeRange = FormatTypeSignalRef | Seq[HeightElement] | NullValue
given Decoder[FontSizeRange] =
  List[Decoder[FontSizeRange]](
    Decoder[FormatTypeSignalRef].widen,
    Decoder[Seq[HeightElement]].widen,
    Decoder[NullValue].widen
  ).reduceLeft(_ or _)

given Encoder[FontSizeRange] = Encoder.instance {
  case enc0: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc0)
  case enc1: Seq[HeightElement]  => Encoder.encodeSeq[HeightElement].apply(enc1)
  case enc2: NullValue           => Encoder.encodeNone(enc2)
}

case class ForceElement(
    val force: ForceEnum,
    val x: Option[XUnion] = None,
    val y: Option[XUnion] = None,
    val iterations: Option[HeightElement] = None,
    val radius: Option[Radius] = None,
    val strength: Option[StrengthUnion] = None,
    val distanceMax: Option[HeightElement] = None,
    val distanceMin: Option[HeightElement] = None,
    val theta: Option[HeightElement] = None,
    val distance: Option[Radius] = None,
    val id: Option[ColorElement] = None,
    val links: Option[String] = None
) derives Encoder.AsObject,
      Decoder

type ForceEnum = "center" | "collide" | "link" | "nbody" | "x" | "y"
type StrengthUnion = Double | StrengthSignalRef
given Decoder[StrengthUnion] =
  List[Decoder[StrengthUnion]](
    Decoder[Double].widen,
    Decoder[StrengthSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[StrengthUnion] = Encoder.instance {
  case enc0: Double            => Encoder.encodeDouble(enc0)
  case enc1: StrengthSignalRef => Encoder.AsObject[StrengthSignalRef].apply(enc1)
}

case class StrengthSignalRef(
    val signal: Option[String] = None,
    val as: Option[String] = None,
    val expr: Option[String] = None,
    val field: Option[String] = None
) derives Encoder.AsObject,
      Decoder

type XUnion = Double | StickySignalRef | String
given Decoder[XUnion] =
  List[Decoder[XUnion]](
    Decoder[Double].widen,
    Decoder[StickySignalRef].widen,
    Decoder[String].widen
  ).reduceLeft(_ or _)

given Encoder[XUnion] = Encoder.instance {
  case enc0: Double          => Encoder.encodeDouble(enc0)
  case enc1: StickySignalRef => Encoder.AsObject[StickySignalRef].apply(enc1)
  case enc2: String          => Encoder.encodeString(enc2)
}

case class StickySignalRef(
    val signal: Option[String] = None,
    val as: Option[String] = None,
    val field: Option[String] = None,
    val expr: Option[String] = None
) derives Encoder.AsObject,
      Decoder

type Params = FormatTypeSignalRef | Seq[FrameElement]
given Decoder[Params] =
  List[Decoder[Params]](
    Decoder[FormatTypeSignalRef].widen,
    Decoder[Seq[FrameElement]].widen
  ).reduceLeft(_ or _)

given Encoder[Params] = Encoder.instance {
  case enc0: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc0)
  case enc1: Seq[FrameElement]   => Encoder.encodeSeq[FrameElement].apply(enc1)
}

type FrameElement = Double | FormatTypeSignalRef | NullValue
given Decoder[FrameElement] =
  List[Decoder[FrameElement]](
    Decoder[Double].widen,
    Decoder[FormatTypeSignalRef].widen,
    Decoder[NullValue].widen
  ).reduceLeft(_ or _)

given Encoder[FrameElement] = Encoder.instance {
  case enc0: Double              => Encoder.encodeDouble(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
  case enc2: NullValue           => Encoder.encodeNone(enc2)
}

type GroupbyUnion = FormatTypeSignalRef | Seq[ColorElement]
given Decoder[GroupbyUnion] =
  List[Decoder[GroupbyUnion]](
    Decoder[FormatTypeSignalRef].widen,
    Decoder[Seq[ColorElement]].widen
  ).reduceLeft(_ or _)

given Encoder[GroupbyUnion] = Encoder.instance {
  case enc0: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc0)
  case enc1: Seq[ColorElement]   => Encoder.encodeSeq[ColorElement].apply(enc1)
}

type TransformOffset = OffsetEnum | FormatTypeSignalRef | Seq[HeightElement]
given Decoder[TransformOffset] =
  List[Decoder[TransformOffset]](
    Decoder[OffsetEnum].widen,
    Decoder[FormatTypeSignalRef].widen,
    Decoder[Seq[HeightElement]].widen
  ).reduceLeft(_ or _)

given Encoder[TransformOffset] = Encoder.instance {
  case enc0: OffsetEnum          => Encoder.encodeString(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
  case enc2: Seq[HeightElement]  => Encoder.encodeSeq[HeightElement].apply(enc2)
}

type OffsetEnum = "center" | "normalize" | "zero"
type TransformOp = PurpleOp | FormatTypeSignalRef
given Decoder[TransformOp] =
  List[Decoder[TransformOp]](
    Decoder[PurpleOp].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[TransformOp] = Encoder.instance {
  case enc0: PurpleOp            => Encoder.encodeString(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
}

type PurpleOp = "__count__" | "argmax" | "argmin" | "average" | "ci0" | "ci1" | "count" | "distinct" | "max" | "mean" |
  "median" | "min" | "missing" | "product" | "q1" | "q3" | "stderr" | "stdev" | "stdevp" | "sum" | "valid" | "values" |
  "variance" | "variancep"
type Ops = FormatTypeSignalRef | Seq[OpElement]
given Decoder[Ops] =
  List[Decoder[Ops]](
    Decoder[FormatTypeSignalRef].widen,
    Decoder[Seq[OpElement]].widen
  ).reduceLeft(_ or _)

given Encoder[Ops] = Encoder.instance {
  case enc0: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc0)
  case enc1: Seq[OpElement]      => Encoder.encodeSeq[OpElement].apply(enc1)
}

type OpElement = FluffyOp | FormatTypeSignalRef
given Decoder[OpElement] =
  List[Decoder[OpElement]](
    Decoder[FluffyOp].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[OpElement] = Encoder.instance {
  case enc0: FluffyOp            => Encoder.encodeString(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
}

type FluffyOp = "__count__" | "argmax" | "argmin" | "average" | "ci0" | "ci1" | "count" | "cume_dist" | "dense_rank" |
  "distinct" | "first_value" | "lag" | "last_value" | "lead" | "max" | "mean" | "median" | "min" | "missing" |
  "next_value" | "nth_value" | "ntile" | "percent_rank" | "prev_value" | "product" | "q1" | "q3" | "rank" |
  "row_number" | "stderr" | "stdev" | "stdevp" | "sum" | "valid" | "values" | "variance" | "variancep"
type TransformOrient = PurpleOrient | FormatTypeSignalRef
given Decoder[TransformOrient] =
  List[Decoder[TransformOrient]](
    Decoder[PurpleOrient].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[TransformOrient] = Encoder.instance {
  case enc0: PurpleOrient        => Encoder.encodeString(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
}

type PurpleOrient = "horizontal" | "radial" | "vertical"
type TransformPadding = Double | PaddingExpr | NullValue
given Decoder[TransformPadding] =
  List[Decoder[TransformPadding]](
    Decoder[Double].widen,
    Decoder[PaddingExpr].widen,
    Decoder[NullValue].widen
  ).reduceLeft(_ or _)

given Encoder[TransformPadding] = Encoder.instance {
  case enc0: Double      => Encoder.encodeDouble(enc0)
  case enc1: PaddingExpr => Encoder.AsObject[PaddingExpr].apply(enc1)
  case enc2: NullValue   => Encoder.encodeNone(enc2)
}

case class PaddingExpr(
    val signal: Option[String] = None,
    val as: Option[String] = None,
    val expr: Option[String] = None,
    val field: Option[String] = None
) derives Encoder.AsObject,
      Decoder

type ParamsUnion = Boolean | FormatTypeSignalRef | Seq[FrameElement]
given Decoder[ParamsUnion] =
  List[Decoder[ParamsUnion]](
    Decoder[Boolean].widen,
    Decoder[FormatTypeSignalRef].widen,
    Decoder[Seq[FrameElement]].widen
  ).reduceLeft(_ or _)

given Encoder[ParamsUnion] = Encoder.instance {
  case enc0: Boolean             => Encoder.encodeBoolean(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
  case enc2: Seq[FrameElement]   => Encoder.encodeSeq[FrameElement].apply(enc2)
}

type ResolveUnion = ResolveEnum | FormatTypeSignalRef
given Decoder[ResolveUnion] =
  List[Decoder[ResolveUnion]](
    Decoder[ResolveEnum].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[ResolveUnion] = Encoder.instance {
  case enc0: ResolveEnum         => Encoder.encodeString(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
}

type ResolveEnum = "independent" | "shared"
type ShapeUnion = ShapeEnum | FormatTypeSignalRef
given Decoder[ShapeUnion] =
  List[Decoder[ShapeUnion]](
    Decoder[ShapeEnum].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[ShapeUnion] = Encoder.instance {
  case enc0: ShapeEnum           => Encoder.encodeString(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
}

type ShapeEnum = "arc" | "curve" | "diagonal" | "line" | "orthogonal"
type SortUnion = Boolean | CompareClass
given Decoder[SortUnion] =
  List[Decoder[SortUnion]](
    Decoder[Boolean].widen,
    Decoder[CompareClass].widen
  ).reduceLeft(_ or _)

given Encoder[SortUnion] = Encoder.instance {
  case enc0: Boolean      => Encoder.encodeBoolean(enc0)
  case enc1: CompareClass => Encoder.AsObject[CompareClass].apply(enc1)
}

case class CompareClass(
    val signal: Option[String] = None,
    val field: Option[CompareField] = None,
    val order: Option[OrderUnion] = None
) derives Encoder.AsObject,
      Decoder

type CompareField = IndigoSignalRef | String | Seq[FieldField]
given Decoder[CompareField] =
  List[Decoder[CompareField]](
    Decoder[IndigoSignalRef].widen,
    Decoder[String].widen,
    Decoder[Seq[FieldField]].widen
  ).reduceLeft(_ or _)

given Encoder[CompareField] = Encoder.instance {
  case enc0: IndigoSignalRef => Encoder.AsObject[IndigoSignalRef].apply(enc0)
  case enc1: String          => Encoder.encodeString(enc1)
  case enc2: Seq[FieldField] => Encoder.encodeSeq[FieldField].apply(enc2)
}

type FieldField = IndigoSignalRef | String
given Decoder[FieldField] =
  List[Decoder[FieldField]](
    Decoder[IndigoSignalRef].widen,
    Decoder[String].widen
  ).reduceLeft(_ or _)

given Encoder[FieldField] = Encoder.instance {
  case enc0: IndigoSignalRef => Encoder.AsObject[IndigoSignalRef].apply(enc0)
  case enc1: String          => Encoder.encodeString(enc1)
}

case class IndigoSignalRef(
    val signal: Option[String] = None,
    val as: Option[String] = None,
    val expr: Option[String] = None
) derives Encoder.AsObject,
      Decoder

type OrderUnion = OrderEnum | FormatTypeSignalRef | Seq[SortOrder]
given Decoder[OrderUnion] =
  List[Decoder[OrderUnion]](
    Decoder[OrderEnum].widen,
    Decoder[FormatTypeSignalRef].widen,
    Decoder[Seq[SortOrder]].widen
  ).reduceLeft(_ or _)

given Encoder[OrderUnion] = Encoder.instance {
  case enc0: OrderEnum           => Encoder.encodeString(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
  case enc2: Seq[SortOrder]      => Encoder.encodeSeq[SortOrder].apply(enc2)
}

type SortOrder = OrderEnum | FormatTypeSignalRef
given Decoder[SortOrder] =
  List[Decoder[SortOrder]](
    Decoder[OrderEnum].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[SortOrder] = Encoder.instance {
  case enc0: OrderEnum           => Encoder.encodeString(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
}

type OrderEnum = "ascending" | "descending"
type TimezoneUnion = TimezoneEnum | FormatTypeSignalRef
given Decoder[TimezoneUnion] =
  List[Decoder[TimezoneUnion]](
    Decoder[TimezoneEnum].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[TimezoneUnion] = Encoder.instance {
  case enc0: TimezoneEnum        => Encoder.encodeString(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
}

type TimezoneEnum = "local" | "utc"
type CaseUnion = CaseEnum | FormatTypeSignalRef
given Decoder[CaseUnion] =
  List[Decoder[CaseUnion]](
    Decoder[CaseEnum].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[CaseUnion] = Encoder.instance {
  case enc0: CaseEnum            => Encoder.encodeString(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
}

type CaseEnum = "lower" | "mixed" | "upper"
type TransformType = "aggregate" | "bin" | "collect" | "contour" | "countpattern" | "cross" | "crossfilter" |
  "density" | "dotbin" | "extent" | "filter" | "flatten" | "fold" | "force" | "formula" | "geojson" | "geopath" |
  "geopoint" | "geoshape" | "graticule" | "heatmap" | "identifier" | "impute" | "isocontour" | "joinaggregate" | "kde" |
  "kde2d" | "label" | "linkpath" | "loess" | "lookup" | "nest" | "pack" | "partition" | "pie" | "pivot" | "project" |
  "quantile" | "regression" | "resolvefilter" | "sample" | "sequence" | "stack" | "stratify" | "timeunit" | "tree" |
  "treelinks" | "treemap" | "voronoi" | "window" | "wordcloud"
type Translate = FormatTypeSignalRef | Seq[Radius]
given Decoder[Translate] =
  List[Decoder[Translate]](
    Decoder[FormatTypeSignalRef].widen,
    Decoder[Seq[Radius]].widen
  ).reduceLeft(_ or _)

given Encoder[Translate] = Encoder.instance {
  case enc0: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc0)
  case enc1: Seq[Radius]         => Encoder.encodeSeq[Radius].apply(enc1)
}

type Units = FormatTypeSignalRef | Seq[UnitElement]
given Decoder[Units] =
  List[Decoder[Units]](
    Decoder[FormatTypeSignalRef].widen,
    Decoder[Seq[UnitElement]].widen
  ).reduceLeft(_ or _)

given Encoder[Units] = Encoder.instance {
  case enc0: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc0)
  case enc1: Seq[UnitElement]    => Encoder.encodeSeq[UnitElement].apply(enc1)
}

type UnitElement = UnitEnum | FormatTypeSignalRef
given Decoder[UnitElement] =
  List[Decoder[UnitElement]](
    Decoder[UnitEnum].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[UnitElement] = Encoder.instance {
  case enc0: UnitEnum            => Encoder.encodeString(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
}

type UnitEnum = "date" | "day" | "dayofyear" | "hours" | "milliseconds" | "minutes" | "month" | "quarter" | "seconds" |
  "week" | "year"
type ValuesUnion = FormatTypeSignalRef | Seq[ValueElement]
given Decoder[ValuesUnion] =
  List[Decoder[ValuesUnion]](
    Decoder[FormatTypeSignalRef].widen,
    Decoder[Seq[ValueElement]].widen
  ).reduceLeft(_ or _)

given Encoder[ValuesUnion] = Encoder.instance {
  case enc0: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc0)
  case enc1: Seq[ValueElement]   => Encoder.encodeSeq[ValueElement].apply(enc1)
}

type ValueElement = Double | IndecentSignalRef | String
given Decoder[ValueElement] =
  List[Decoder[ValueElement]](
    Decoder[Double].widen,
    Decoder[IndecentSignalRef].widen,
    Decoder[String].widen
  ).reduceLeft(_ or _)

given Encoder[ValueElement] = Encoder.instance {
  case enc0: Double            => Encoder.encodeDouble(enc0)
  case enc1: IndecentSignalRef => Encoder.AsObject[IndecentSignalRef].apply(enc1)
  case enc2: String            => Encoder.encodeString(enc2)
}

case class IndecentSignalRef(
    val signal: Option[String] = None,
    val as: Option[String] = None,
    val field: Option[String] = None,
    val expr: Option[String] = None
) derives Encoder.AsObject,
      Decoder

case class VegaEncode() derives Encoder.AsObject, Decoder

case class Layout(
    val align: Option[AlignUnion] = None,
    val bounds: Option[BoundsUnion] = None,
    val center: Option[Center] = None,
    val columns: Option[HeightElement] = None,
    val footerBand: Option[FooterBandUnion] = None,
    val headerBand: Option[HeaderBandUnion] = None,
    val offset: Option[LayoutOffset] = None,
    val padding: Option[PaddingUnion] = None,
    val titleAnchor: Option[TitleAnchor] = None,
    val titleBand: Option[TitleBandUnion] = None,
    val signal: Option[String] = None
) derives Encoder.AsObject,
      Decoder

type AlignUnion = AlignEnum | HilariousSignalRef
given Decoder[AlignUnion] =
  List[Decoder[AlignUnion]](
    Decoder[AlignEnum].widen,
    Decoder[HilariousSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[AlignUnion] = Encoder.instance {
  case enc0: AlignEnum          => Encoder.encodeString(enc0)
  case enc1: HilariousSignalRef => Encoder.AsObject[HilariousSignalRef].apply(enc1)
}

case class HilariousSignalRef(
    val signal: Option[String] = None,
    val column: Option[GridAlignUnion] = None,
    val row: Option[GridAlignUnion] = None
) derives Encoder.AsObject,
      Decoder

type GridAlignUnion = AlignEnum | FormatTypeSignalRef
given Decoder[GridAlignUnion] =
  List[Decoder[GridAlignUnion]](
    Decoder[AlignEnum].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[GridAlignUnion] = Encoder.instance {
  case enc0: AlignEnum           => Encoder.encodeString(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
}

type AlignEnum = "all" | "each" | "none"
type BoundsUnion = BoundsEnum | FormatTypeSignalRef
given Decoder[BoundsUnion] =
  List[Decoder[BoundsUnion]](
    Decoder[BoundsEnum].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[BoundsUnion] = Encoder.instance {
  case enc0: BoundsEnum          => Encoder.encodeString(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
}

type BoundsEnum = "flush" | "full"
type Center = AmbitiousSignalRef | Boolean
given Decoder[Center] =
  List[Decoder[Center]](
    Decoder[AmbitiousSignalRef].widen,
    Decoder[Boolean].widen
  ).reduceLeft(_ or _)

given Encoder[Center] = Encoder.instance {
  case enc0: AmbitiousSignalRef => Encoder.AsObject[AmbitiousSignalRef].apply(enc0)
  case enc1: Boolean            => Encoder.encodeBoolean(enc1)
}

case class AmbitiousSignalRef(
    val signal: Option[String] = None,
    val column: Option[TickExtraUnion] = None,
    val row: Option[TickExtraUnion] = None
) derives Encoder.AsObject,
      Decoder

type FooterBandUnion = Double | FooterBandSignalRef | NullValue
given Decoder[FooterBandUnion] =
  List[Decoder[FooterBandUnion]](
    Decoder[Double].widen,
    Decoder[FooterBandSignalRef].widen,
    Decoder[NullValue].widen
  ).reduceLeft(_ or _)

given Encoder[FooterBandUnion] = Encoder.instance {
  case enc0: Double              => Encoder.encodeDouble(enc0)
  case enc1: FooterBandSignalRef => Encoder.AsObject[FooterBandSignalRef].apply(enc1)
  case enc2: NullValue           => Encoder.encodeNone(enc2)
}

case class FooterBandSignalRef(
    val signal: Option[String] = None,
    val column: Option[HeightElement] = None,
    val row: Option[HeightElement] = None
) derives Encoder.AsObject,
      Decoder

type HeaderBandUnion = Double | HeaderBandSignalRef | NullValue
given Decoder[HeaderBandUnion] =
  List[Decoder[HeaderBandUnion]](
    Decoder[Double].widen,
    Decoder[HeaderBandSignalRef].widen,
    Decoder[NullValue].widen
  ).reduceLeft(_ or _)

given Encoder[HeaderBandUnion] = Encoder.instance {
  case enc0: Double              => Encoder.encodeDouble(enc0)
  case enc1: HeaderBandSignalRef => Encoder.AsObject[HeaderBandSignalRef].apply(enc1)
  case enc2: NullValue           => Encoder.encodeNone(enc2)
}

case class HeaderBandSignalRef(
    val signal: Option[String] = None,
    val column: Option[HeightElement] = None,
    val row: Option[HeightElement] = None
) derives Encoder.AsObject,
      Decoder

type LayoutOffset = CunningSignalRef | Double
given Decoder[LayoutOffset] =
  List[Decoder[LayoutOffset]](
    Decoder[CunningSignalRef].widen,
    Decoder[Double].widen
  ).reduceLeft(_ or _)

given Encoder[LayoutOffset] = Encoder.instance {
  case enc0: CunningSignalRef => Encoder.AsObject[CunningSignalRef].apply(enc0)
  case enc1: Double           => Encoder.encodeDouble(enc1)
}

case class CunningSignalRef(
    val signal: Option[String] = None,
    val columnFooter: Option[HeightElement] = None,
    val columnHeader: Option[HeightElement] = None,
    val columnTitle: Option[HeightElement] = None,
    val rowFooter: Option[HeightElement] = None,
    val rowHeader: Option[HeightElement] = None,
    val rowTitle: Option[HeightElement] = None
) derives Encoder.AsObject,
      Decoder

type PaddingUnion = Double | MagentaSignalRef
given Decoder[PaddingUnion] =
  List[Decoder[PaddingUnion]](
    Decoder[Double].widen,
    Decoder[MagentaSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[PaddingUnion] = Encoder.instance {
  case enc0: Double           => Encoder.encodeDouble(enc0)
  case enc1: MagentaSignalRef => Encoder.AsObject[MagentaSignalRef].apply(enc1)
}

case class MagentaSignalRef(
    val signal: Option[String] = None,
    val column: Option[HeightElement] = None,
    val row: Option[HeightElement] = None
) derives Encoder.AsObject,
      Decoder

type TitleAnchor = TitleAnchorEnum | TitleAnchorSignalRef
given Decoder[TitleAnchor] =
  List[Decoder[TitleAnchor]](
    Decoder[TitleAnchorEnum].widen,
    Decoder[TitleAnchorSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[TitleAnchor] = Encoder.instance {
  case enc0: TitleAnchorEnum      => Encoder.encodeString(enc0)
  case enc1: TitleAnchorSignalRef => Encoder.AsObject[TitleAnchorSignalRef].apply(enc1)
}

case class TitleAnchorSignalRef(
    val signal: Option[String] = None,
    val column: Option[PurpleColumn] = None,
    val row: Option[PurpleColumn] = None
) derives Encoder.AsObject,
      Decoder

type PurpleColumn = TitleAnchorEnum | FormatTypeSignalRef
given Decoder[PurpleColumn] =
  List[Decoder[PurpleColumn]](
    Decoder[TitleAnchorEnum].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[PurpleColumn] = Encoder.instance {
  case enc0: TitleAnchorEnum     => Encoder.encodeString(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
}

type TitleAnchorEnum = "end" | "start"
type TitleBandUnion = Double | TitleBandSignalRef | NullValue
given Decoder[TitleBandUnion] =
  List[Decoder[TitleBandUnion]](
    Decoder[Double].widen,
    Decoder[TitleBandSignalRef].widen,
    Decoder[NullValue].widen
  ).reduceLeft(_ or _)

given Encoder[TitleBandUnion] = Encoder.instance {
  case enc0: Double             => Encoder.encodeDouble(enc0)
  case enc1: TitleBandSignalRef => Encoder.AsObject[TitleBandSignalRef].apply(enc1)
  case enc2: NullValue          => Encoder.encodeNone(enc2)
}

case class TitleBandSignalRef(
    val signal: Option[String] = None,
    val column: Option[HeightElement] = None,
    val row: Option[HeightElement] = None
) derives Encoder.AsObject,
      Decoder

case class Legend(
    val aria: Option[Boolean] = None,
    val clipHeight: Option[HeightElement] = None,
    val columnPadding: Option[HeightElement] = None,
    val columns: Option[HeightElement] = None,
    val cornerRadius: Option[BandPositionUnion] = None,
    val description: Option[String] = None,
    val direction: Option[Direction] = None,
    val encode: Option[LegendEncode] = None,
    val fill: Option[String] = None,
    val fillColor: Option[DomainColorUnion] = None,
    val format: Option[LegendFormat] = None,
    val formatType: Option[FormatTypeUnion] = None,
    val gradientLength: Option[HeightElement] = None,
    val gradientOpacity: Option[BandPositionUnion] = None,
    val gradientStrokeColor: Option[DomainColorUnion] = None,
    val gradientStrokeWidth: Option[BandPositionUnion] = None,
    val gradientThickness: Option[HeightElement] = None,
    val gridAlign: Option[GridAlignUnion] = None,
    val labelAlign: Option[LabelAlignUnion] = None,
    val labelBaseline: Option[LabelBaselineUnion] = None,
    val labelColor: Option[DomainColorUnion] = None,
    val labelFont: Option[DomainCapUnion] = None,
    val labelFontSize: Option[BandPositionUnion] = None,
    val labelFontStyle: Option[DomainCapUnion] = None,
    val labelFontWeight: Option[LabelFontWeightUnion] = None,
    val labelLimit: Option[BandPositionUnion] = None,
    val labelOffset: Option[BandPositionUnion] = None,
    val labelOpacity: Option[BandPositionUnion] = None,
    val labelOverlap: Option[LabelOverlap] = None,
    val labelSeparation: Option[HeightElement] = None,
    val legendX: Option[BandPositionUnion] = None,
    val legendY: Option[BandPositionUnion] = None,
    val offset: Option[BandPositionUnion] = None,
    val opacity: Option[String] = None,
    val orient: Option[LegendOrient] = None,
    val padding: Option[BandPositionUnion] = None,
    val rowPadding: Option[HeightElement] = None,
    val shape: Option[String] = None,
    val size: Option[String] = None,
    val stroke: Option[String] = None,
    val strokeColor: Option[DomainColorUnion] = None,
    val strokeDash: Option[String] = None,
    val strokeWidth: Option[String] = None,
    val symbolDash: Option[DomainDashUnion] = None,
    val symbolDashOffset: Option[BandPositionUnion] = None,
    val symbolFillColor: Option[DomainColorUnion] = None,
    val symbolLimit: Option[HeightElement] = None,
    val symbolOffset: Option[BandPositionUnion] = None,
    val symbolOpacity: Option[BandPositionUnion] = None,
    val symbolSize: Option[BandPositionUnion] = None,
    val symbolStrokeColor: Option[DomainColorUnion] = None,
    val symbolStrokeWidth: Option[BandPositionUnion] = None,
    val symbolType: Option[DomainCapUnion] = None,
    val tickCount: Option[TickCount] = None,
    val tickMinStep: Option[HeightElement] = None,
    val title: Option[TextOrSignal] = None,
    val titleAlign: Option[LabelAlignUnion] = None,
    val titleAnchor: Option[TitleAnchorUnion] = None,
    val titleBaseline: Option[LabelBaselineUnion] = None,
    val titleColor: Option[DomainColorUnion] = None,
    val titleFont: Option[DomainCapUnion] = None,
    val titleFontSize: Option[BandPositionUnion] = None,
    val titleFontStyle: Option[DomainCapUnion] = None,
    val titleFontWeight: Option[LabelFontWeightUnion] = None,
    val titleLimit: Option[BandPositionUnion] = None,
    val titleLineHeight: Option[BandPositionUnion] = None,
    val titleOpacity: Option[BandPositionUnion] = None,
    val titleOrient: Option[TitleOrientUnion] = None,
    val titlePadding: Option[BandPositionUnion] = None,
    val `type`: Option[LegendType] = None,
    val values: Option[ArrayOrSignal] = None,
    val zindex: Option[Double] = None
) derives Encoder.AsObject,
      Decoder

type Direction = "horizontal" | "vertical"
case class LegendEncode(
    val entries: Option[GuideEncode] = None,
    val gradient: Option[GuideEncode] = None,
    val labels: Option[GuideEncode] = None,
    val legend: Option[GuideEncode] = None,
    val symbols: Option[GuideEncode] = None,
    val title: Option[GuideEncode] = None
) derives Encoder.AsObject,
      Decoder

type LegendFormat = FriskySignalRef | String
given Decoder[LegendFormat] =
  List[Decoder[LegendFormat]](
    Decoder[FriskySignalRef].widen,
    Decoder[String].widen
  ).reduceLeft(_ or _)

given Encoder[LegendFormat] = Encoder.instance {
  case enc0: FriskySignalRef => Encoder.AsObject[FriskySignalRef].apply(enc0)
  case enc1: String          => Encoder.encodeString(enc1)
}

case class FriskySignalRef(
    val date: Option[String] = None,
    val day: Option[String] = None,
    val hours: Option[String] = None,
    val milliseconds: Option[String] = None,
    val minutes: Option[String] = None,
    val month: Option[String] = None,
    val quarter: Option[String] = None,
    val seconds: Option[String] = None,
    val week: Option[String] = None,
    val year: Option[String] = None,
    val signal: Option[String] = None
) derives Encoder.AsObject,
      Decoder

type LegendType = "gradient" | "symbol"
type LegendOrient = FluffyOrient | FormatTypeSignalRef
given Decoder[LegendOrient] =
  List[Decoder[LegendOrient]](
    Decoder[FluffyOrient].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[LegendOrient] = Encoder.instance {
  case enc0: FluffyOrient        => Encoder.encodeString(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
}

type FluffyOrient = "bottom" | "bottom-left" | "bottom-right" | "left" | "none" | "right" | "top" | "top-left" |
  "top-right"
type TitleOrientUnion = TitleOrientEnum | OrientValue | Seq[TitleOrientElement]
given Decoder[TitleOrientUnion] =
  List[Decoder[TitleOrientUnion]](
    Decoder[TitleOrientEnum].widen,
    Decoder[OrientValue].widen,
    Decoder[Seq[TitleOrientElement]].widen
  ).reduceLeft(_ or _)

given Encoder[TitleOrientUnion] = Encoder.instance {
  case enc0: TitleOrientEnum         => Encoder.encodeString(enc0)
  case enc1: OrientValue             => Encoder.AsObject[OrientValue].apply(enc1)
  case enc2: Seq[TitleOrientElement] => Encoder.encodeSeq[TitleOrientElement].apply(enc2)
}

case class TitleOrientElement(
    val test: Option[String] = None,
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

case class OrientValue(
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

case class MarkEncode(
    val enter: Option[EncodeEntry] = None,
    val update: Option[EncodeEntry] = None,
    val hover: Option[EncodeEntry] = None
) derives Encoder.AsObject,
      Decoder

case class Mark(
    val from: Option[From] = None,
    val `type`: String,
    val aria: Option[Boolean] = None,
    val clip: Option[Markclip] = None,
    val description: Option[String] = None,
    val encode: Option[MarkEncode] = None,
    val interactive: Option[TickExtraUnion] = None,
    val key: Option[String] = None,
    val name: Option[String] = None,
    val on: Option[Seq[OnMarkTrigger]] = None,
    val role: Option[String] = None,
    val sort: Option[Compare] = None,
    val style: Option[Style] = None,
    val transform: Option[Seq[TransformMark]] = None,
    val axes: Option[Seq[Axis]] = None,
    val data: Option[Seq[Data]] = None,
    val layout: Option[Layout] = None,
    val legends: Option[Seq[Legend]] = None,
    val marks: Option[Seq[Mark]] = None,
    val projections: Option[Seq[Projection]] = None,
    val scales: Option[Seq[Scale]] = None,
    val signals: Option[Seq[Signal]] = None,
    val title: Option[Title] = None,
    val usermeta: Option[Map[String, Option[Json]]] = None
) derives Encoder.AsObject,
      Decoder

type Markclip = Boolean | MarkclipSignalRef
given Decoder[Markclip] =
  List[Decoder[Markclip]](
    Decoder[Boolean].widen,
    Decoder[MarkclipSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[Markclip] = Encoder.instance {
  case enc0: Boolean           => Encoder.encodeBoolean(enc0)
  case enc1: MarkclipSignalRef => Encoder.AsObject[MarkclipSignalRef].apply(enc1)
}

case class MarkclipSignalRef(
    val signal: Option[String] = None,
    val path: Option[BackgroundElement] = None,
    val sphere: Option[BackgroundElement] = None
) derives Encoder.AsObject,
      Decoder

case class EncodeEntry(
    val align: Option[AlignValue] = None,
    val angle: Option[NumberValue] = None,
    val aria: Option[BooleanValue] = None,
    val ariaRole: Option[StringValue] = None,
    val aspect: Option[BooleanValue] = None,
    val ariaRoleDescription: Option[StringValue] = None,
    val baseline: Option[BaselineValue] = None,
    val blend: Option[BlendValue] = None,
    val clip: Option[BooleanValue] = None,
    val cornerRadius: Option[NumberValue] = None,
    val cornerRadiusBottomLeft: Option[NumberValue] = None,
    val cornerRadiusBottomRight: Option[NumberValue] = None,
    val cornerRadiusTopLeft: Option[NumberValue] = None,
    val cornerRadiusTopRight: Option[NumberValue] = None,
    val cursor: Option[StringValue] = None,
    val defined: Option[BooleanValue] = None,
    val description: Option[StringValue] = None,
    val dir: Option[StringValue] = None,
    val dx: Option[NumberValue] = None,
    val dy: Option[NumberValue] = None,
    val ellipsis: Option[StringValue] = None,
    val endAngle: Option[NumberValue] = None,
    val fill: Option[ColorValue] = None,
    val fillOpacity: Option[NumberValue] = None,
    val font: Option[StringValue] = None,
    val fontSize: Option[NumberValue] = None,
    val fontStyle: Option[StringValue] = None,
    val fontWeight: Option[FontWeightValue] = None,
    val height: Option[NumberValue] = None,
    val innerRadius: Option[NumberValue] = None,
    val interpolate: Option[StringValue] = None,
    val limit: Option[NumberValue] = None,
    val lineBreak: Option[StringValue] = None,
    val lineHeight: Option[NumberValue] = None,
    val opacity: Option[NumberValue] = None,
    val orient: Option[DirectionValue] = None,
    val outerRadius: Option[NumberValue] = None,
    val padAngle: Option[NumberValue] = None,
    val path: Option[StringValue] = None,
    val radius: Option[NumberValue] = None,
    val scaleX: Option[NumberValue] = None,
    val scaleY: Option[NumberValue] = None,
    val shape: Option[StringValue] = None,
    val size: Option[NumberValue] = None,
    val smooth: Option[BooleanValue] = None,
    val startAngle: Option[NumberValue] = None,
    val stroke: Option[ColorValue] = None,
    val strokeCap: Option[StrokeCapValue] = None,
    val strokeDash: Option[ArrayValue] = None,
    val strokeDashOffset: Option[NumberValue] = None,
    val strokeForeground: Option[BooleanValue] = None,
    val strokeJoin: Option[StrokeJoinValue] = None,
    val strokeMiterLimit: Option[NumberValue] = None,
    val strokeOffset: Option[NumberValue] = None,
    val strokeOpacity: Option[NumberValue] = None,
    val strokeWidth: Option[NumberValue] = None,
    val tension: Option[NumberValue] = None,
    val text: Option[TextValue] = None,
    val theta: Option[NumberValue] = None,
    val tooltip: Option[AnyValue] = None,
    val url: Option[StringValue] = None,
    val width: Option[NumberValue] = None,
    val x: Option[NumberValue] = None,
    val x2: Option[NumberValue] = None,
    val xc: Option[NumberValue] = None,
    val y: Option[NumberValue] = None,
    val y2: Option[NumberValue] = None,
    val yc: Option[NumberValue] = None,
    val zindex: Option[NumberValue] = None
) derives Encoder.AsObject,
      Decoder

type AlignValue = LabelAlignClass | Seq[LabelAlignElement]
given Decoder[AlignValue] =
  List[Decoder[AlignValue]](
    Decoder[LabelAlignClass].widen,
    Decoder[Seq[LabelAlignElement]].widen
  ).reduceLeft(_ or _)

given Encoder[AlignValue] = Encoder.instance {
  case enc0: LabelAlignClass        => Encoder.AsObject[LabelAlignClass].apply(enc0)
  case enc1: Seq[LabelAlignElement] => Encoder.encodeSeq[LabelAlignElement].apply(enc1)
}

type BooleanValue = TickRoundClass | Seq[TickRoundElement]
given Decoder[BooleanValue] =
  List[Decoder[BooleanValue]](
    Decoder[TickRoundClass].widen,
    Decoder[Seq[TickRoundElement]].widen
  ).reduceLeft(_ or _)

given Encoder[BooleanValue] = Encoder.instance {
  case enc0: TickRoundClass        => Encoder.AsObject[TickRoundClass].apply(enc0)
  case enc1: Seq[TickRoundElement] => Encoder.encodeSeq[TickRoundElement].apply(enc1)
}

type StringValue = DomainCapClass | Seq[DomainCapElement]
given Decoder[StringValue] =
  List[Decoder[StringValue]](
    Decoder[DomainCapClass].widen,
    Decoder[Seq[DomainCapElement]].widen
  ).reduceLeft(_ or _)

given Encoder[StringValue] = Encoder.instance {
  case enc0: DomainCapClass        => Encoder.AsObject[DomainCapClass].apply(enc0)
  case enc1: Seq[DomainCapElement] => Encoder.encodeSeq[DomainCapElement].apply(enc1)
}

type BaselineValue = LabelBaselineClass | Seq[LabelBaselineElement]
given Decoder[BaselineValue] =
  List[Decoder[BaselineValue]](
    Decoder[LabelBaselineClass].widen,
    Decoder[Seq[LabelBaselineElement]].widen
  ).reduceLeft(_ or _)

given Encoder[BaselineValue] = Encoder.instance {
  case enc0: LabelBaselineClass        => Encoder.AsObject[LabelBaselineClass].apply(enc0)
  case enc1: Seq[LabelBaselineElement] => Encoder.encodeSeq[LabelBaselineElement].apply(enc1)
}

type BlendValue = BlendValueClass | Seq[BlendValueElement]
given Decoder[BlendValue] =
  List[Decoder[BlendValue]](
    Decoder[BlendValueClass].widen,
    Decoder[Seq[BlendValueElement]].widen
  ).reduceLeft(_ or _)

given Encoder[BlendValue] = Encoder.instance {
  case enc0: BlendValueClass        => Encoder.AsObject[BlendValueClass].apply(enc0)
  case enc1: Seq[BlendValueElement] => Encoder.encodeSeq[BlendValueElement].apply(enc1)
}

case class BlendValueElement(
    val test: Option[String] = None,
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

case class BlendValueClass(
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

type ColorValue = Seq[BaseColorValue] | FluffyBaseColorValue
given Decoder[ColorValue] =
  List[Decoder[ColorValue]](
    Decoder[Seq[BaseColorValue]].widen,
    Decoder[FluffyBaseColorValue].widen
  ).reduceLeft(_ or _)

given Encoder[ColorValue] = Encoder.instance {
  case enc0: Seq[BaseColorValue]  => Encoder.encodeSeq[BaseColorValue].apply(enc0)
  case enc1: FluffyBaseColorValue => Encoder.AsObject[FluffyBaseColorValue].apply(enc1)
}

case class FluffyBaseColorValue(
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None,
    val count: Option[Double] = None,
    val gradient: Option[Field] = None,
    val start: Option[Seq[Double]] = None,
    val stop: Option[Seq[Double]] = None,
    val color: Option[Color] = None
) derives Encoder.AsObject,
      Decoder

type FontWeightValue = LabelFontWeightClass | Seq[LabelFontWeightElement]
given Decoder[FontWeightValue] =
  List[Decoder[FontWeightValue]](
    Decoder[LabelFontWeightClass].widen,
    Decoder[Seq[LabelFontWeightElement]].widen
  ).reduceLeft(_ or _)

given Encoder[FontWeightValue] = Encoder.instance {
  case enc0: LabelFontWeightClass        => Encoder.AsObject[LabelFontWeightClass].apply(enc0)
  case enc1: Seq[LabelFontWeightElement] => Encoder.encodeSeq[LabelFontWeightElement].apply(enc1)
}

type DirectionValue = DirectionValueClass | Seq[DirectionValueElement]
given Decoder[DirectionValue] =
  List[Decoder[DirectionValue]](
    Decoder[DirectionValueClass].widen,
    Decoder[Seq[DirectionValueElement]].widen
  ).reduceLeft(_ or _)

given Encoder[DirectionValue] = Encoder.instance {
  case enc0: DirectionValueClass        => Encoder.AsObject[DirectionValueClass].apply(enc0)
  case enc1: Seq[DirectionValueElement] => Encoder.encodeSeq[DirectionValueElement].apply(enc1)
}

case class DirectionValueElement(
    val test: Option[String] = None,
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

case class DirectionValueClass(
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

type StrokeCapValue = StrokeCapValueClass | Seq[StrokeCapValueElement]
given Decoder[StrokeCapValue] =
  List[Decoder[StrokeCapValue]](
    Decoder[StrokeCapValueClass].widen,
    Decoder[Seq[StrokeCapValueElement]].widen
  ).reduceLeft(_ or _)

given Encoder[StrokeCapValue] = Encoder.instance {
  case enc0: StrokeCapValueClass        => Encoder.AsObject[StrokeCapValueClass].apply(enc0)
  case enc1: Seq[StrokeCapValueElement] => Encoder.encodeSeq[StrokeCapValueElement].apply(enc1)
}

case class StrokeCapValueElement(
    val test: Option[String] = None,
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

case class StrokeCapValueClass(
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

type ArrayValue = DomainDashClass | Seq[DomainDashElement]
given Decoder[ArrayValue] =
  List[Decoder[ArrayValue]](
    Decoder[DomainDashClass].widen,
    Decoder[Seq[DomainDashElement]].widen
  ).reduceLeft(_ or _)

given Encoder[ArrayValue] = Encoder.instance {
  case enc0: DomainDashClass        => Encoder.AsObject[DomainDashClass].apply(enc0)
  case enc1: Seq[DomainDashElement] => Encoder.encodeSeq[DomainDashElement].apply(enc1)
}

type StrokeJoinValue = StrokeJoinValueClass | Seq[StrokeJoinValueElement]
given Decoder[StrokeJoinValue] =
  List[Decoder[StrokeJoinValue]](
    Decoder[StrokeJoinValueClass].widen,
    Decoder[Seq[StrokeJoinValueElement]].widen
  ).reduceLeft(_ or _)

given Encoder[StrokeJoinValue] = Encoder.instance {
  case enc0: StrokeJoinValueClass        => Encoder.AsObject[StrokeJoinValueClass].apply(enc0)
  case enc1: Seq[StrokeJoinValueElement] => Encoder.encodeSeq[StrokeJoinValueElement].apply(enc1)
}

case class StrokeJoinValueElement(
    val test: Option[String] = None,
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

case class StrokeJoinValueClass(
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

type TextValue = TextValueClass | Seq[TextValueElement]
given Decoder[TextValue] =
  List[Decoder[TextValue]](
    Decoder[TextValueClass].widen,
    Decoder[Seq[TextValueElement]].widen
  ).reduceLeft(_ or _)

given Encoder[TextValue] = Encoder.instance {
  case enc0: TextValueClass        => Encoder.AsObject[TextValueClass].apply(enc0)
  case enc1: Seq[TextValueElement] => Encoder.encodeSeq[TextValueElement].apply(enc1)
}

case class TextValueElement(
    val test: Option[String] = None,
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

case class TextValueClass(
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

type AnyValue = AnyValueClass | Seq[AnyValueElement]
given Decoder[AnyValue] =
  List[Decoder[AnyValue]](
    Decoder[AnyValueClass].widen,
    Decoder[Seq[AnyValueElement]].widen
  ).reduceLeft(_ or _)

given Encoder[AnyValue] = Encoder.instance {
  case enc0: AnyValueClass        => Encoder.AsObject[AnyValueClass].apply(enc0)
  case enc1: Seq[AnyValueElement] => Encoder.encodeSeq[AnyValueElement].apply(enc1)
}

case class AnyValueElement(
    val test: Option[String] = None,
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

case class AnyValueClass(
    val scale: Option[Field] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None,
    val field: Option[Field] = None,
    val range: Option[Band] = None,
    val band: Option[Json] = None,
    val offset: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

case class From(
    val data: Option[String] = None,
    val facet: Option[Facet] = None
) derives Encoder.AsObject,
      Decoder

case class Facet(
    val data: String,
    val field: Option[String] = None,
    val name: String,
    val aggregate: Option[Aggregate] = None,
    val groupby: Option[Style] = None
) derives Encoder.AsObject,
      Decoder

case class Aggregate(
    val as: Option[Seq[String]] = None,
    val cross: Option[Boolean] = None,
    val fields: Option[Seq[String]] = None,
    val ops: Option[Seq[String]] = None
) derives Encoder.AsObject,
      Decoder

case class OnMarkTrigger(
    val modify: Option[String] = None,
    val trigger: String,
    val values: Option[String] = None
) derives Encoder.AsObject,
      Decoder

case class Projection(
    val center: Option[CenterElement] = None,
    val clipAngle: Option[HeightElement] = None,
    val clipExtent: Option[Extent] = None,
    val extent: Option[Extent] = None,
    val fit: Option[Fit] = None,
    val name: String,
    val parallels: Option[CenterElement] = None,
    val pointRadius: Option[HeightElement] = None,
    val precision: Option[HeightElement] = None,
    val rotate: Option[CenterElement] = None,
    val scale: Option[HeightElement] = None,
    val size: Option[CenterElement] = None,
    val translate: Option[CenterElement] = None,
    val `type`: Option[BackgroundElement] = None
) derives Encoder.AsObject,
      Decoder

type Extent = FormatTypeSignalRef | Seq[CenterElement]
given Decoder[Extent] =
  List[Decoder[Extent]](
    Decoder[FormatTypeSignalRef].widen,
    Decoder[Seq[CenterElement]].widen
  ).reduceLeft(_ or _)

given Encoder[Extent] = Encoder.instance {
  case enc0: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc0)
  case enc1: Seq[CenterElement]  => Encoder.encodeSeq[CenterElement].apply(enc1)
}

type Fit = Seq[Option[Json]] | Map[String, Option[Json]]
given Decoder[Fit] =
  List[Decoder[Fit]](
    Decoder[Seq[Option[Json]]].widen,
    Decoder[Map[String, Option[Json]]].widen
  ).reduceLeft(_ or _)

given Encoder[Fit] = Encoder.instance {
  case enc0: Seq[Option[Json]]         => Encoder.encodeSeq[Option[Json]].apply(enc0)
  case enc1: Map[String, Option[Json]] => Encoder.encodeMap[String, Option[Json]].apply(enc1)
}

case class Scale(
    val domain: Option[ScaleData] = None,
    val domainMax: Option[HeightElement] = None,
    val domainMid: Option[HeightElement] = None,
    val domainMin: Option[HeightElement] = None,
    val domainRaw: Option[DomainRaw] = None,
    val name: String,
    val nice: Option[PurpleBooleanOrSignal] = None,
    val reverse: Option[TickExtraUnion] = None,
    val round: Option[TickExtraUnion] = None,
    val `type`: Option[ScaleType] = None,
    val domainImplicit: Option[TickExtraUnion] = None,
    val interpolate: Option[ScaleInterpolate] = None,
    val range: Option[RangeUnion] = None,
    val align: Option[HeightElement] = None,
    val padding: Option[HeightElement] = None,
    val paddingInner: Option[HeightElement] = None,
    val paddingOuter: Option[HeightElement] = None,
    val zero: Option[TickExtraUnion] = None,
    val bins: Option[ScaleBins] = None,
    val clamp: Option[TickExtraUnion] = None,
    val base: Option[HeightElement] = None,
    val exponent: Option[HeightElement] = None,
    val constant: Option[HeightElement] = None
) derives Encoder.AsObject,
      Decoder

type ScaleBins = ScaleBinsSignalRef | Seq[HeightElement]
given Decoder[ScaleBins] =
  List[Decoder[ScaleBins]](
    Decoder[ScaleBinsSignalRef].widen,
    Decoder[Seq[HeightElement]].widen
  ).reduceLeft(_ or _)

given Encoder[ScaleBins] = Encoder.instance {
  case enc0: ScaleBinsSignalRef => Encoder.AsObject[ScaleBinsSignalRef].apply(enc0)
  case enc1: Seq[HeightElement] => Encoder.encodeSeq[HeightElement].apply(enc1)
}

case class ScaleBinsSignalRef(
    val start: Option[HeightElement] = None,
    val step: Option[HeightElement] = None,
    val stop: Option[HeightElement] = None,
    val signal: Option[String] = None
) derives Encoder.AsObject,
      Decoder

type ScaleData = MischievousSignalRef | Seq[Domain]
given Decoder[ScaleData] =
  List[Decoder[ScaleData]](
    Decoder[MischievousSignalRef].widen,
    Decoder[Seq[Domain]].widen
  ).reduceLeft(_ or _)

given Encoder[ScaleData] = Encoder.instance {
  case enc0: MischievousSignalRef => Encoder.AsObject[MischievousSignalRef].apply(enc0)
  case enc1: Seq[Domain]          => Encoder.encodeSeq[Domain].apply(enc1)
}

type Domain = Boolean | Double | FormatTypeSignalRef | String | Seq[HeightElement] | NullValue
given Decoder[Domain] =
  List[Decoder[Domain]](
    Decoder[Boolean].widen,
    Decoder[Double].widen,
    Decoder[FormatTypeSignalRef].widen,
    Decoder[String].widen,
    Decoder[Seq[HeightElement]].widen,
    Decoder[NullValue].widen
  ).reduceLeft(_ or _)

given Encoder[Domain] = Encoder.instance {
  case enc0: Boolean             => Encoder.encodeBoolean(enc0)
  case enc1: Double              => Encoder.encodeDouble(enc1)
  case enc2: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc2)
  case enc3: String              => Encoder.encodeString(enc3)
  case enc4: Seq[HeightElement]  => Encoder.encodeSeq[HeightElement].apply(enc4)
  case enc5: NullValue           => Encoder.encodeNone(enc5)
}

case class MischievousSignalRef(
    val data: Option[String] = None,
    val field: Option[BackgroundElement] = None,
    val sort: Option[TentacledSort] = None,
    val fields: Option[Seq[PurpleStringOrSignal]] = None,
    val signal: Option[String] = None
) derives Encoder.AsObject,
      Decoder

type PurpleStringOrSignal = BraggadociousSignalRef | String | Seq[FieldElement]
given Decoder[PurpleStringOrSignal] =
  List[Decoder[PurpleStringOrSignal]](
    Decoder[BraggadociousSignalRef].widen,
    Decoder[String].widen,
    Decoder[Seq[FieldElement]].widen
  ).reduceLeft(_ or _)

given Encoder[PurpleStringOrSignal] = Encoder.instance {
  case enc0: BraggadociousSignalRef => Encoder.AsObject[BraggadociousSignalRef].apply(enc0)
  case enc1: String                 => Encoder.encodeString(enc1)
  case enc2: Seq[FieldElement]      => Encoder.encodeSeq[FieldElement].apply(enc2)
}

type FieldElement = Boolean | Double | String
given Decoder[FieldElement] =
  List[Decoder[FieldElement]](
    Decoder[Boolean].widen,
    Decoder[Double].widen,
    Decoder[String].widen
  ).reduceLeft(_ or _)

given Encoder[FieldElement] = Encoder.instance {
  case enc0: Boolean => Encoder.encodeBoolean(enc0)
  case enc1: Double  => Encoder.encodeDouble(enc1)
  case enc2: String  => Encoder.encodeString(enc2)
}

case class BraggadociousSignalRef(
    val signal: Option[String] = None,
    val data: Option[String] = None,
    val field: Option[BackgroundElement] = None
) derives Encoder.AsObject,
      Decoder

type TentacledSort = Boolean | PurpleSort
given Decoder[TentacledSort] =
  List[Decoder[TentacledSort]](
    Decoder[Boolean].widen,
    Decoder[PurpleSort].widen
  ).reduceLeft(_ or _)

given Encoder[TentacledSort] = Encoder.instance {
  case enc0: Boolean    => Encoder.encodeBoolean(enc0)
  case enc1: PurpleSort => Encoder.AsObject[PurpleSort].apply(enc1)
}

case class PurpleSort(
    val field: Option[BackgroundElement] = None,
    val op: Option[BackgroundElement] = None,
    val order: Option[SortOrder] = None
) derives Encoder.AsObject,
      Decoder

type DomainRaw = Seq[Option[Json]] | FormatTypeSignalRef | NullValue
given Decoder[DomainRaw] =
  List[Decoder[DomainRaw]](
    Decoder[Seq[Option[Json]]].widen,
    Decoder[FormatTypeSignalRef].widen,
    Decoder[NullValue].widen
  ).reduceLeft(_ or _)

given Encoder[DomainRaw] = Encoder.instance {
  case enc0: Seq[Option[Json]]   => Encoder.encodeSeq[Option[Json]].apply(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
  case enc2: NullValue           => Encoder.encodeNone(enc2)
}

type ScaleInterpolate = ScaleInterpolateSignalRef | String
given Decoder[ScaleInterpolate] =
  List[Decoder[ScaleInterpolate]](
    Decoder[ScaleInterpolateSignalRef].widen,
    Decoder[String].widen
  ).reduceLeft(_ or _)

given Encoder[ScaleInterpolate] = Encoder.instance {
  case enc0: ScaleInterpolateSignalRef => Encoder.AsObject[ScaleInterpolateSignalRef].apply(enc0)
  case enc1: String                    => Encoder.encodeString(enc1)
}

case class ScaleInterpolateSignalRef(
    val signal: Option[String] = None,
    val gamma: Option[HeightElement] = None,
    val `type`: Option[BackgroundElement] = None
) derives Encoder.AsObject,
      Decoder

type PurpleBooleanOrSignal = Boolean | Double | TickCountEnum | SignalRef1
given Decoder[PurpleBooleanOrSignal] =
  List[Decoder[PurpleBooleanOrSignal]](
    Decoder[Boolean].widen,
    Decoder[Double].widen,
    Decoder[TickCountEnum].widen,
    Decoder[SignalRef1].widen
  ).reduceLeft(_ or _)

given Encoder[PurpleBooleanOrSignal] = Encoder.instance {
  case enc0: Boolean       => Encoder.encodeBoolean(enc0)
  case enc1: Double        => Encoder.encodeDouble(enc1)
  case enc2: TickCountEnum => Encoder.encodeString(enc2)
  case enc3: SignalRef1    => Encoder.AsObject[SignalRef1].apply(enc3)
}

case class SignalRef1(
    val signal: Option[String] = None,
    val interval: Option[Interval] = None,
    val step: Option[HeightElement] = None
) derives Encoder.AsObject,
      Decoder

type RangeUnion = RangeEnum | SignalRef2 | Seq[Domain]
given Decoder[RangeUnion] =
  List[Decoder[RangeUnion]](
    Decoder[RangeEnum].widen,
    Decoder[SignalRef2].widen,
    Decoder[Seq[Domain]].widen
  ).reduceLeft(_ or _)

given Encoder[RangeUnion] = Encoder.instance {
  case enc0: RangeEnum   => Encoder.encodeString(enc0)
  case enc1: SignalRef2  => Encoder.AsObject[SignalRef2].apply(enc1)
  case enc2: Seq[Domain] => Encoder.encodeSeq[Domain].apply(enc2)
}

case class SignalRef2(
    val count: Option[HeightElement] = None,
    val extent: Option[CenterElement] = None,
    val scheme: Option[Scheme] = None,
    val data: Option[String] = None,
    val field: Option[BackgroundElement] = None,
    val sort: Option[StickySort] = None,
    val fields: Option[Seq[FluffyStringOrSignal]] = None,
    val signal: Option[String] = None,
    val step: Option[HeightElement] = None
) derives Encoder.AsObject,
      Decoder

type FluffyStringOrSignal = SignalRef3 | String | Seq[FieldElement]
given Decoder[FluffyStringOrSignal] =
  List[Decoder[FluffyStringOrSignal]](
    Decoder[SignalRef3].widen,
    Decoder[String].widen,
    Decoder[Seq[FieldElement]].widen
  ).reduceLeft(_ or _)

given Encoder[FluffyStringOrSignal] = Encoder.instance {
  case enc0: SignalRef3        => Encoder.AsObject[SignalRef3].apply(enc0)
  case enc1: String            => Encoder.encodeString(enc1)
  case enc2: Seq[FieldElement] => Encoder.encodeSeq[FieldElement].apply(enc2)
}

case class SignalRef3(
    val signal: Option[String] = None,
    val data: Option[String] = None,
    val field: Option[BackgroundElement] = None
) derives Encoder.AsObject,
      Decoder

type Scheme = FormatTypeSignalRef | String | Seq[BackgroundElement]
given Decoder[Scheme] =
  List[Decoder[Scheme]](
    Decoder[FormatTypeSignalRef].widen,
    Decoder[String].widen,
    Decoder[Seq[BackgroundElement]].widen
  ).reduceLeft(_ or _)

given Encoder[Scheme] = Encoder.instance {
  case enc0: FormatTypeSignalRef    => Encoder.AsObject[FormatTypeSignalRef].apply(enc0)
  case enc1: String                 => Encoder.encodeString(enc1)
  case enc2: Seq[BackgroundElement] => Encoder.encodeSeq[BackgroundElement].apply(enc2)
}

type StickySort = Boolean | FluffySort
given Decoder[StickySort] =
  List[Decoder[StickySort]](
    Decoder[Boolean].widen,
    Decoder[FluffySort].widen
  ).reduceLeft(_ or _)

given Encoder[StickySort] = Encoder.instance {
  case enc0: Boolean    => Encoder.encodeBoolean(enc0)
  case enc1: FluffySort => Encoder.AsObject[FluffySort].apply(enc1)
}

case class FluffySort(
    val field: Option[BackgroundElement] = None,
    val op: Option[BackgroundElement] = None,
    val order: Option[SortOrder] = None
) derives Encoder.AsObject,
      Decoder

type RangeEnum = "category" | "diverging" | "heatmap" | "height" | "ordinal" | "ramp" | "symbol" | "width"
type ScaleType = "band" | "bin-ordinal" | "identity" | "linear" | "log" | "ordinal" | "point" | "pow" | "quantile" |
  "quantize" | "sequential" | "sqrt" | "symlog" | "threshold" | "time" | "utc"
case class Signal(
    val description: Option[String] = None,
    val name: String,
    val on: Option[Seq[OnEvent]] = None,
    val push: Option[Push] = None,
    val bind: Option[Bind] = None,
    val react: Option[Boolean] = None,
    val update: Option[String] = None,
    val value: Option[Json] = None,
    val init: Option[String] = None
) derives Encoder.AsObject,
      Decoder

case class Bind(
    val debounce: Option[Double] = None,
    val element: Option[String] = None,
    val input: Option[Json] = None,
    val name: Option[String] = None,
    val labels: Option[Seq[String]] = None,
    val options: Option[Seq[Option[Json]]] = None,
    val max: Option[Double] = None,
    val min: Option[Double] = None,
    val step: Option[Double] = None,
    val event: Option[String] = None
) derives Encoder.AsObject,
      Decoder

case class OnEvent(
    val events: EventsUnion,
    val force: Option[Boolean] = None,
    val encode: Option[String] = None,
    val update: Option[Update] = None
) derives Encoder.AsObject,
      Decoder

type EventsUnion = Seq[Listener] | StreamClass | String
given Decoder[EventsUnion] =
  List[Decoder[EventsUnion]](
    Decoder[Seq[Listener]].widen,
    Decoder[StreamClass].widen,
    Decoder[String].widen
  ).reduceLeft(_ or _)

given Encoder[EventsUnion] = Encoder.instance {
  case enc0: Seq[Listener] => Encoder.encodeSeq[Listener].apply(enc0)
  case enc1: StreamClass   => Encoder.AsObject[StreamClass].apply(enc1)
  case enc2: String        => Encoder.encodeString(enc2)
}

case class Listener(
    val signal: Option[String] = None,
    val scale: Option[String] = None,
    val between: Option[Seq[Stream]] = None,
    val consume: Option[Boolean] = None,
    val debounce: Option[Double] = None,
    val filter: Option[Style] = None,
    val markname: Option[String] = None,
    val marktype: Option[String] = None,
    val throttle: Option[Double] = None,
    val source: Option[String] = None,
    val `type`: Option[String] = None,
    val stream: Option[Stream] = None,
    val merge: Option[Seq[Stream]] = None
) derives Encoder.AsObject,
      Decoder

case class Stream(
    val between: Option[Seq[Stream]] = None,
    val consume: Option[Boolean] = None,
    val debounce: Option[Double] = None,
    val filter: Option[Style] = None,
    val markname: Option[String] = None,
    val marktype: Option[String] = None,
    val throttle: Option[Double] = None,
    val source: Option[String] = None,
    val `type`: Option[String] = None,
    val stream: Option[Stream] = None,
    val merge: Option[Seq[Stream]] = None
) derives Encoder.AsObject,
      Decoder

case class StreamClass(
    val signal: Option[String] = None,
    val scale: Option[String] = None,
    val between: Option[Seq[Stream]] = None,
    val consume: Option[Boolean] = None,
    val debounce: Option[Double] = None,
    val filter: Option[Style] = None,
    val markname: Option[String] = None,
    val marktype: Option[String] = None,
    val throttle: Option[Double] = None,
    val source: Option[String] = None,
    val `type`: Option[String] = None,
    val stream: Option[Stream] = None,
    val merge: Option[Seq[Stream]] = None
) derives Encoder.AsObject,
      Decoder

type Update = Expr | String
given Decoder[Update] =
  List[Decoder[Update]](
    Decoder[Expr].widen,
    Decoder[String].widen
  ).reduceLeft(_ or _)

given Encoder[Update] = Encoder.instance {
  case enc0: Expr   => Encoder.AsObject[Expr].apply(enc0)
  case enc1: String => Encoder.encodeString(enc1)
}

case class Expr(
    val as: Option[String] = None,
    val expr: Option[String] = None,
    val signal: Option[String] = None,
    val value: Option[Json] = None
) derives Encoder.AsObject,
      Decoder

type Push = "outer"
case class Compare(
    val field: Option[CompareField] = None,
    val order: Option[OrderUnion] = None
) derives Encoder.AsObject,
      Decoder

type Title = String | TitleClass
given Decoder[Title] =
  List[Decoder[Title]](
    Decoder[String].widen,
    Decoder[TitleClass].widen
  ).reduceLeft(_ or _)

given Encoder[Title] = Encoder.instance {
  case enc0: String     => Encoder.encodeString(enc0)
  case enc1: TitleClass => Encoder.AsObject[TitleClass].apply(enc1)
}

case class TitleClass(
    val align: Option[LabelAlignUnion] = None,
    val anchor: Option[TitleAnchorUnion] = None,
    val angle: Option[BandPositionUnion] = None,
    val aria: Option[Boolean] = None,
    val baseline: Option[LabelBaselineUnion] = None,
    val color: Option[DomainColorUnion] = None,
    val dx: Option[BandPositionUnion] = None,
    val dy: Option[BandPositionUnion] = None,
    val encode: Option[TitleEncode] = None,
    val font: Option[DomainCapUnion] = None,
    val fontSize: Option[BandPositionUnion] = None,
    val fontStyle: Option[DomainCapUnion] = None,
    val fontWeight: Option[LabelFontWeightUnion] = None,
    val frame: Option[FrameUnion] = None,
    val interactive: Option[Boolean] = None,
    val limit: Option[BandPositionUnion] = None,
    val lineHeight: Option[BandPositionUnion] = None,
    val name: Option[String] = None,
    val offset: Option[BandPositionUnion] = None,
    val orient: Option[TitleOrient] = None,
    val style: Option[Style] = None,
    val subtitle: Option[TextOrSignal] = None,
    val subtitleColor: Option[DomainColorUnion] = None,
    val subtitleFont: Option[DomainCapUnion] = None,
    val subtitleFontSize: Option[BandPositionUnion] = None,
    val subtitleFontStyle: Option[DomainCapUnion] = None,
    val subtitleFontWeight: Option[LabelFontWeightUnion] = None,
    val subtitleLineHeight: Option[BandPositionUnion] = None,
    val subtitlePadding: Option[HeightElement] = None,
    val text: Option[TextOrSignal] = None,
    val zindex: Option[Double] = None
) derives Encoder.AsObject,
      Decoder

case class TitleEncode(
    val group: Option[GuideEncode] = None,
    val subtitle: Option[GuideEncode] = None,
    val title: Option[GuideEncode] = None
) derives Encoder.AsObject,
      Decoder

type FrameUnion = DomainCapClass | Seq[DomainCapElement] | Frame
given Decoder[FrameUnion] =
  List[Decoder[FrameUnion]](
    Decoder[DomainCapClass].widen,
    Decoder[Seq[DomainCapElement]].widen,
    Decoder[Frame].widen
  ).reduceLeft(_ or _)

given Encoder[FrameUnion] = Encoder.instance {
  case enc0: DomainCapClass        => Encoder.AsObject[DomainCapClass].apply(enc0)
  case enc1: Seq[DomainCapElement] => Encoder.encodeSeq[DomainCapElement].apply(enc1)
  case enc2: Frame                 => Encoder.encodeString(enc2)
}

type Frame = "bounds" | "group"
type TitleOrient = TentacledOrient | FormatTypeSignalRef
given Decoder[TitleOrient] =
  List[Decoder[TitleOrient]](
    Decoder[TentacledOrient].widen,
    Decoder[FormatTypeSignalRef].widen
  ).reduceLeft(_ or _)

given Encoder[TitleOrient] = Encoder.instance {
  case enc0: TentacledOrient     => Encoder.encodeString(enc0)
  case enc1: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc1)
}

type TentacledOrient = "bottom" | "left" | "none" | "right" | "top"
case class TransformMark(
    val fields: Option[FieldsUnion] = None,
    val query: Option[ArrayOrSignal] = None,
    val signal: Option[String] = None,
    val `type`: TransformMarkType,
    val filter: Option[Json] = None,
    val ignore: Option[HeightElement] = None,
    val as: Option[TransformMarkAs] = None,
    val orient: Option[TransformOrient] = None,
    val require: Option[FormatTypeSignalRef] = None,
    val shape: Option[ShapeUnion] = None,
    val sourceX: Option[ColorElement] = None,
    val sourceY: Option[ColorElement] = None,
    val targetX: Option[ColorElement] = None,
    val targetY: Option[ColorElement] = None,
    val endAngle: Option[HeightElement] = None,
    val field: Option[ColorElement] = None,
    val sort: Option[SortUnion] = None,
    val startAngle: Option[HeightElement] = None,
    val groupby: Option[GroupbyUnion] = None,
    val offset: Option[TransformOffset] = None,
    val alpha: Option[HeightElement] = None,
    val alphaMin: Option[HeightElement] = None,
    val alphaTarget: Option[HeightElement] = None,
    val forces: Option[Seq[ForceElement]] = None,
    val iterations: Option[HeightElement] = None,
    val restart: Option[TickExtraUnion] = None,
    val static: Option[TickExtraUnion] = None,
    val velocityDecay: Option[HeightElement] = None,
    val geojson: Option[ColorElement] = None,
    val pointRadius: Option[Radius] = None,
    val projection: Option[String] = None,
    val color: Option[ColorElement] = None,
    val opacity: Option[Radius] = None,
    val resolve: Option[ResolveUnion] = None,
    val padding: Option[TransformPadding] = None,
    val radius: Option[ColorElement] = None,
    val size: Option[StepsUnion] = None,
    val round: Option[TickExtraUnion] = None,
    val key: Option[ColorElement] = None,
    val parentKey: Option[ColorElement] = None,
    val method: Option[BackgroundElement] = None,
    val nodeSize: Option[CenterElement] = None,
    val separation: Option[TickExtraUnion] = None,
    val paddingBottom: Option[HeightElement] = None,
    val paddingInner: Option[HeightElement] = None,
    val paddingLeft: Option[HeightElement] = None,
    val paddingOuter: Option[HeightElement] = None,
    val paddingRight: Option[HeightElement] = None,
    val paddingTop: Option[HeightElement] = None,
    val ratio: Option[HeightElement] = None,
    val anchor: Option[AnchorUnion] = None,
    val avoidBaseMark: Option[TickExtraUnion] = None,
    val avoidMarks: Option[AvoidMarks] = None,
    val lineAnchor: Option[BackgroundElement] = None,
    val markIndex: Option[HeightElement] = None,
    val base: Option[HeightElement] = None,
    val divide: Option[CenterElement] = None,
    val extent: Option[ArrayOrSignal] = None,
    val interval: Option[TickExtraUnion] = None,
    val maxbins: Option[HeightElement] = None,
    val minstep: Option[HeightElement] = None,
    val name: Option[BackgroundElement] = None,
    val nice: Option[TickExtraUnion] = None,
    val span: Option[HeightElement] = None,
    val step: Option[HeightElement] = None,
    val steps: Option[CenterElement] = None,
    val smooth: Option[TickExtraUnion] = None,
    val expr: Option[String] = None,
    val initonly: Option[TickExtraUnion] = None,
    val ops: Option[Ops] = None,
    val default: Option[Json] = None,
    val from: Option[String] = None,
    val values: Option[GroupbyUnion] = None,
    val timezone: Option[TimezoneUnion] = None,
    val units: Option[Units] = None,
    val frame: Option[Params] = None,
    val ignorePeers: Option[TickExtraUnion] = None,
    val params: Option[Params] = None,
    val x: Option[ColorElement] = None,
    val y: Option[ColorElement] = None,
    val font: Option[ColorElement] = None,
    val fontSize: Option[Radius] = None,
    val fontSizeRange: Option[FontSizeRange] = None,
    val fontStyle: Option[ColorElement] = None,
    val fontWeight: Option[ColorElement] = None,
    val rotate: Option[Radius] = None,
    val spiral: Option[BackgroundElement] = None,
    val text: Option[ColorElement] = None
) derives Encoder.AsObject,
      Decoder

type TransformMarkAs = FormatTypeSignalRef | String | Seq[AElement]
given Decoder[TransformMarkAs] =
  List[Decoder[TransformMarkAs]](
    Decoder[FormatTypeSignalRef].widen,
    Decoder[String].widen,
    Decoder[Seq[AElement]].widen
  ).reduceLeft(_ or _)

given Encoder[TransformMarkAs] = Encoder.instance {
  case enc0: FormatTypeSignalRef => Encoder.AsObject[FormatTypeSignalRef].apply(enc0)
  case enc1: String              => Encoder.encodeString(enc1)
  case enc2: Seq[AElement]       => Encoder.encodeSeq[AElement].apply(enc2)
}

type TransformMarkType = "bin" | "collect" | "crossfilter" | "dotbin" | "extent" | "force" | "formula" | "geojson" |
  "geopath" | "geopoint" | "geoshape" | "heatmap" | "identifier" | "joinaggregate" | "label" | "linkpath" | "lookup" |
  "pack" | "partition" | "pie" | "resolvefilter" | "sample" | "stack" | "stratify" | "timeunit" | "tree" | "treemap" |
  "voronoi" | "window" | "wordcloud"
type Padding = Double | SignalRef4
given Decoder[Padding] =
  List[Decoder[Padding]](
    Decoder[Double].widen,
    Decoder[SignalRef4].widen
  ).reduceLeft(_ or _)

given Encoder[Padding] = Encoder.instance {
  case enc0: Double     => Encoder.encodeDouble(enc0)
  case enc1: SignalRef4 => Encoder.AsObject[SignalRef4].apply(enc1)
}

case class SignalRef4(
    val bottom: Option[Double] = None,
    val left: Option[Double] = None,
    val right: Option[Double] = None,
    val top: Option[Double] = None,
    val signal: Option[String] = None
) derives Encoder.AsObject,
      Decoder
