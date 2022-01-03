package viz.vega.plots

import viz.FromUrl
import viz.PlotTarget
import viz.vega.plots.SpecUrl

type JsonMod = Seq[ujson.Obj => Unit]

// Vega
case class BarChart(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BarChart)
case class StackedBarChart(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.StackedBarChart)
case class GroupedBarChart(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.GroupedBarChart)
case class NestedBarChart(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.NestedBarChart)
case class PopulationPyramid(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.PopulationPyramid)
case class LineChart(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LineChart)
case class AreaChart(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.AreaChart)
case class StackedAreaChart(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.StackedAreaChart)
case class HorizonGraph(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.HorizonGraph)
case class JobVoyager(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.JobVoyager)
case class PieChart(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.PieChart)
case class DonutChart(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.DonutChart)
case class RadialPlot(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.RadialPlot)
case class RadarChart(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.RadarChart)
case class ScatterPlot(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ScatterPlot)
case class ScatterPlotNullValues(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ScatterPlotNullValues)
case class ConnectedScatterPlot(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ConnectedScatterPlot)
case class ErrorBars(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ErrorBars)
case class BarleyTrellisPlot(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BarleyTrellisPlot)
case class Regression(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Regression)
case class LoessRegression(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LoessRegression)
case class LabeledScatterPlot(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LabeledScatterPlot)
case class TopKPlot(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.TopKPlot)
case class TopKPlotWithOthers(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.TopKPlotWithOthers)
case class Histogram(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Histogram)
case class HistogramNullValues(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.HistogramNullValues)
case class DotPlot(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.DotPlot)
case class ProbabilityDensity(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ProbabilityDensity)
case class BoxPlot(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BoxPlot)
case class ViolinPlot(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ViolinPlot)
case class BinnedScatterPlot(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BinnedScatterPlot)
case class ContourPlot(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ContourPlot)
case class WheatPlot(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.WheatPlot)
case class QuantileQuantilePlot(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.QuantileQuantilePlot)
case class QuantileDotPlot(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.QuantileDotPlot)
case class HypotheticalOutcomePlots(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.HypotheticalOutcomePlots)
case class TimeUnits(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.TimeUnits)
case class CountyUnemployment(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.CountyUnemployment)
case class DorlingCartogram(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.DorlingCartogram)
case class WorldMap(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.WorldMap)
case class Earthquakes(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Earthquakes)
case class Projections(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Projections)
case class ZoomableWorldMap(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ZoomableWorldMap)
case class DistortionComparison(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.DistortionComparison)
case class VolcanoContours(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.VolcanoContours)
case class WindVectors(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.WindVectors)
case class AnnualPrecipitation(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.AnnualPrecipitation)
case class TreeLayout(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.TreeLayout)
case class RadialTreeLayout(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.RadialTreeLayout)
case class Treemap(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Treemap)
case class CirclePacking(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.CirclePacking)
case class Sunburst(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Sunburst)
case class EdgeBundling(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.EdgeBundling)
case class ForceDirectedLayout(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ForceDirectedLayout)
case class ReorderableMatrix(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ReorderableMatrix)
case class ArcDiagram(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ArcDiagram)
case class AirportConnections(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.AirportConnections)
case class Heatmap(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Heatmap)
case class DensityHeatmaps(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.DensityHeatmaps)
case class ParallelCoordinates(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ParallelCoordinates)
case class WordCloud(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.WordCloud)
case class BeeswarmPlot(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BeeswarmPlot)
case class CalendarView(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.CalendarView)
case class BudgetForecasts(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BudgetForecasts)
case class WheatAndWages(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.WheatAndWages)
case class FalkenseePopulation(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.FalkenseePopulation)
case class AnnualTemperature(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.AnnualTemperature)
case class WeeklyTemperature(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.WeeklyTemperature)
case class FlightPassengers(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.FlightPassengers)
case class Timelines(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Timelines)
case class UDistrictCuisine(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.UDistrictCuisine)
case class Clock(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Clock)
case class Watch(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Watch)
case class CrossfilterFlights(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.CrossfilterFlights)
case class OverviewPlusDetail(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.OverviewPlusDetail)
case class BrushingScatterPlots(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BrushingScatterPlots)
case class ZoomableScatterPlot(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ZoomableScatterPlot)
case class ZoomableBinnedPlot(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ZoomableBinnedPlot)
case class GlobalDevelopment(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.GlobalDevelopment)
case class InteractiveLegend(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.InteractiveLegend)
case class StockIndexChart(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.StockIndexChart)
case class PiMonteCarlo(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.PiMonteCarlo)
case class Pacman(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Pacman)
case class Platformer(override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Platformer)
//Vega Lite

case class SimpleBarChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.SimpleBarChartLite)
case class ResponsiveBarChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ResponsiveBarChartLite)
case class AggregateBarChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.AggregateBarChartLite)
case class AggregateBarChart_SortedLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.AggregateBarChart_SortedLite)
case class GroupedBarChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.GroupedBarChartLite)
case class GroupedBarChart_MultipleMeasurewithRepeatLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.GroupedBarChart_MultipleMeasurewithRepeatLite)
case class StackedBarChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.StackedBarChartLite)
case class StackedBarChartwithRoundedCornersLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.StackedBarChartwithRoundedCornersLite)
case class HorizontalStackedBarChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.HorizontalStackedBarChartLite)
case class Normalized_PercentageStackedBarChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Normalized_PercentageStackedBarChartLite)
case class Normalized_PercentageStackedBarChartWithLabelsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Normalized_PercentageStackedBarChartWithLabelsLite)
case class GanttChart_RangedBarMarksLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.GanttChart_RangedBarMarksLite)
case class ABarChartEncodingColorNamesintheDataLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ABarChartEncodingColorNamesintheDataLite)
case class LayeredBarChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LayeredBarChartLite)
case class DivergingStackedBarChart_PopulationPyramidLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.DivergingStackedBarChart_PopulationPyramidLite)
case class DivergingStackedBarChart_withNeutralPartsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.DivergingStackedBarChart_withNeutralPartsLite)
case class BarChartwithLabelsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BarChartwithLabelsLite)
case class BarChartwithLabelOverlaysLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BarChartwithLabelOverlaysLite)
case class BarChartshowingInitialsofMonthNamesLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BarChartshowingInitialsofMonthNamesLite)
case class BarChartwithNegativeValuesandaZero_BaselineLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BarChartwithNegativeValuesandaZero_BaselineLite)
case class HorizontalBarChartwithNegativeValuesandLabelsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.HorizontalBarChartwithNegativeValuesandLabelsLite)
case class BarChartwithaSpacing_SavingY_AxisLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BarChartwithaSpacing_SavingY_AxisLite)
case class HistogramLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.HistogramLite)
case class Histogram_fromBinnedDataLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Histogram_fromBinnedDataLite)
case class Log_scaledHistogramLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Log_scaledHistogramLite)
case class Non_linearHistogramLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Non_linearHistogramLite)
case class RelativeFrequencyHistogramLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.RelativeFrequencyHistogramLite)
case class DensityPlotLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.DensityPlotLite)
case class StackedDensityEstimatesLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.StackedDensityEstimatesLite)
case class TwoDHistogramScatterplotLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.TwoDHistogramScatterplotLite)
case class TwoDHistogramHeatmapLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.TwoDHistogramHeatmapLite)
case class CumulativeFrequencyDistributionLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.CumulativeFrequencyDistributionLite)
case class LayeredHistogramandCumulativeHistogramLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LayeredHistogramandCumulativeHistogramLite)
case class WilkinsonDotPlotLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.WilkinsonDotPlotLite)
case class IsotypeDotPlotLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.IsotypeDotPlotLite)
case class IsotypeDotPlotwithEmojiLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.IsotypeDotPlotwithEmojiLite)
case class ScatterplotLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ScatterplotLite)
case class OneDStripPlotLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.OneDStripPlotLite)
case class StripPlotLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.StripPlotLite)
case class ColoredScatterplotLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ColoredScatterplotLite)
case class TwoDHistogramScatterplot0Lite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.TwoDHistogramScatterplot0Lite)
case class BubblePlotLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BubblePlotLite)
case class ScatterplotwithNullValuesinGreyLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ScatterplotwithNullValuesinGreyLite)
case class ScatterplotwithFilledCirclesLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ScatterplotwithFilledCirclesLite)
case class BubblePlot_GapminderLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BubblePlot_GapminderLite)
case class BubblePlot_NaturalDisastersLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BubblePlot_NaturalDisastersLite)
case class ScatterPlotwithTextMarksLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ScatterPlotwithTextMarksLite)
case class Image_basedScatterPlotLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Image_basedScatterPlotLite)
case class StripplotwithcustomaxisticklabelsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.StripplotwithcustomaxisticklabelsLite)
case class DotPlotwithJitteringLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.DotPlotwithJitteringLite)
case class LineChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LineChartLite)
case class LineChartwithPointMarkersLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LineChartwithPointMarkersLite)
case class LineChartwithStrokedPointMarkersLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LineChartwithStrokedPointMarkersLite)
case class MultiSeriesLineChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.MultiSeriesLineChartLite)
case class MultiSeriesLineChartwithRepeatOperatorLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.MultiSeriesLineChartwithRepeatOperatorLite)
case class MultiSeriesLineChartwithHaloStrokeLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.MultiSeriesLineChartwithHaloStrokeLite)
case class SlopeGraphLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.SlopeGraphLite)
case class StepChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.StepChartLite)
case class LineChartwithMonotoneInterpolationLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LineChartwithMonotoneInterpolationLite)
case class LineChartwithConditionalAxisPropertiesLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LineChartwithConditionalAxisPropertiesLite)
case class ConnectedScatterplot_LineswithCustomPathsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ConnectedScatterplot_LineswithCustomPathsLite)
case class BumpChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BumpChartLite)
case class LineChartwithVaryingSize_usingthetrailmarkLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LineChartwithVaryingSize_usingthetrailmarkLite)
case class AcometchartshowingchangesbetweenbetweentwostatesLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.AcometchartshowingchangesbetweenbetweentwostatesLite)
case class LineChartwithMarkersandInvalidValuesLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LineChartwithMarkersandInvalidValuesLite)
case class CarbonDioxideintheAtmosphereLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.CarbonDioxideintheAtmosphereLite)
case class LineChartsShowingRanksOverTimeLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LineChartsShowingRanksOverTimeLite)
case class DrawingSineandCosineCurveswiththeSequenceGeneratorLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.DrawingSineandCosineCurveswiththeSequenceGeneratorLite)
case class LinechartwithvaryingstrokedashLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LinechartwithvaryingstrokedashLite)
case class LinechartwithadashedpartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LinechartwithadashedpartLite)
case class AreaChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.AreaChartLite)
case class AreaChartwithGradientLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.AreaChartwithGradientLite)
case class AreaChartwithOverlayingLinesandPointMarkersLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.AreaChartwithOverlayingLinesandPointMarkersLite)
case class StackedAreaChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.StackedAreaChartLite)
case class NormalizedStackedAreaChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.NormalizedStackedAreaChartLite)
case class StreamgraphLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.StreamgraphLite)
case class HorizonGraphLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.HorizonGraphLite)
case class TableHeatmapLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.TableHeatmapLite)
case class AnnualWeatherHeatmapLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.AnnualWeatherHeatmapLite)
case class TwoDHistogramHeatmap0Lite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.TwoDHistogramHeatmap0Lite)
case class TableBubblePlot_GithubPunchCardLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.TableBubblePlot_GithubPunchCardLite)
case class HeatmapwithLabelsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.HeatmapwithLabelsLite)
case class LasagnaPlot_DenseTime_SeriesHeatmapLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LasagnaPlot_DenseTime_SeriesHeatmapLite)
case class MosaicChartwithLabelsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.MosaicChartwithLabelsLite)
case class WindVectorMapLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.WindVectorMapLite)
case class PieChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.PieChartLite)
case class DonutChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.DonutChartLite)
case class PieChartwithLabelsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.PieChartwithLabelsLite)
case class RadialPlotLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.RadialPlotLite)
case class PyramidPieChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.PyramidPieChartLite)
case class CalculatePercentageofTotalLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.CalculatePercentageofTotalLite)
case class CalculateDifferencefromAverageLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.CalculateDifferencefromAverageLite)
case class CalculateDifferencefromAnnualAverageLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.CalculateDifferencefromAnnualAverageLite)
case class CalculateResidualsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.CalculateResidualsLite)
case class LineChartsShowingRanksOverTime0Lite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LineChartsShowingRanksOverTime0Lite)
case class WaterfallChartofMonthlyProfitandLossLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.WaterfallChartofMonthlyProfitandLossLite)
case class FilteringTop_KItemsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.FilteringTop_KItemsLite)
case class Top_KPlotwithOthersLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Top_KPlotwithOthersLite)
case class UsingthelookuptransformtocombinedataLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.UsingthelookuptransformtocombinedataLite)
case class CumulativeFrequencyDistribution0Lite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.CumulativeFrequencyDistribution0Lite)
case class LayeredHistogramandCumulativeHistogram0Lite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LayeredHistogramandCumulativeHistogram0Lite)
case class ParallelCoordinatePlotLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ParallelCoordinatePlotLite)
case class BarChartShowingArgmaxValueLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BarChartShowingArgmaxValueLite)
case class LayeringAveragesoverRawValuesLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LayeringAveragesoverRawValuesLite)
case class LayeringRollingAveragesoverRawValuesLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LayeringRollingAveragesoverRawValuesLite)
case class LineCharttoShowBenchmarkingResultsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LineCharttoShowBenchmarkingResultsLite)
case class Quantile_QuantilePlot_QQPlotLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Quantile_QuantilePlot_QQPlotLite)
case class LinearRegressionLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LinearRegressionLite)
case class LoessRegressionLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LoessRegressionLite)
case class ErrorBarsShowingConfidenceIntervalLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ErrorBarsShowingConfidenceIntervalLite)
case class ErrorBarsShowingStandardDeviationLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ErrorBarsShowingStandardDeviationLite)
case class LineChartwithConfidenceIntervalBandLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LineChartwithConfidenceIntervalBandLite)
case class ScatterplotwithMeanandStandardDeviationOverlayLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ScatterplotwithMeanandStandardDeviationOverlayLite)
case class BoxPlotwithMin_MaxWhiskersLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BoxPlotwithMin_MaxWhiskersLite)
case class TukeyBoxPlot_One_5IQRLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.TukeyBoxPlot_One_5IQRLite)
case class BoxPlotwithPre_CalculatedSummariesLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BoxPlotwithPre_CalculatedSummariesLite)
case class SimpleBarChartwithLabelsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.SimpleBarChartwithLabelsLite)
case class SimpleBarChartwithLabelsandEmojisLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.SimpleBarChartwithLabelsandEmojisLite)
case class LayeringtextoverheatmapLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LayeringtextoverheatmapLite)
case class CarbonDioxideintheAtmosphere0Lite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.CarbonDioxideintheAtmosphere0Lite)
case class BarChartHighlightingValuesbeyondaThresholdLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BarChartHighlightingValuesbeyondaThresholdLite)
case class MeanoverlayoverprecipitationchartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.MeanoverlayoverprecipitationchartLite)
case class HistogramwithaGlobalMeanOverlayLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.HistogramwithaGlobalMeanOverlayLite)
case class LineChartwithHighlightedRectanglesLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LineChartwithHighlightedRectanglesLite)
case class LayeringAveragesoverRawValues0Lite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LayeringAveragesoverRawValues0Lite)
case class LayeringRollingAveragesoverRawValues0Lite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LayeringRollingAveragesoverRawValues0Lite)
case class DistributionsandMediansofLikertScaleRatingsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.DistributionsandMediansofLikertScaleRatingsLite)
case class ComparativeLikertScaleRatingsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ComparativeLikertScaleRatingsLite)
case class CandlestickChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.CandlestickChartLite)
case class RangedDotPlotLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.RangedDotPlotLite)
case class BulletChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BulletChartLite)
case class LayeredPlotwithDual_AxisLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LayeredPlotwithDual_AxisLite)
case class HorizonGraph0Lite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.HorizonGraph0Lite)
case class WeeklyWeatherPlotLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.WeeklyWeatherPlotLite)
case class WheatandWagesExampleLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.WheatandWagesExampleLite)
case class TrellisBarChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.TrellisBarChartLite)
case class TrellisStackedBarChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.TrellisStackedBarChartLite)
case class TrellisScatterPlot_wrappedLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.TrellisScatterPlot_wrappedLite)
case class TrellisHistogramsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.TrellisHistogramsLite)
case class TrellisScatterPlotShowingAnscombesQuartetLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.TrellisScatterPlotShowingAnscombesQuartetLite)
case class BeckersBarleyTrellisPlotLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BeckersBarleyTrellisPlotLite)
case class TrellisAreaLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.TrellisAreaLite)
case class TrellisAreaPlotShowingAnnualTemperaturesinSeattleLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.TrellisAreaPlotShowingAnnualTemperaturesinSeattleLite)
case class FacetedDensityPlotLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.FacetedDensityPlotLite)
case class CompactTrellisGridofBarChartsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.CompactTrellisGridofBarChartsLite)
case class RepeatandLayertoShowDifferentMovieMeasuresLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.RepeatandLayertoShowDifferentMovieMeasuresLite)
case class VerticalConcatenationLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.VerticalConcatenationLite)
case class HorizontallyRepeatedChartsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.HorizontallyRepeatedChartsLite)
case class InteractiveScatterplotMatrixLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.InteractiveScatterplotMatrixLite)
case class MarginalHistogramsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.MarginalHistogramsLite)
case class DiscretizingscalesLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.DiscretizingscalesLite)
case class NestedViewConcatenationAlignedwithAxisminExtentLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.NestedViewConcatenationAlignedwithAxisminExtentLite)
case class PopulationPyramidLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.PopulationPyramidLite)
case class ChoroplethofUnemploymentRateperCountyLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ChoroplethofUnemploymentRateperCountyLite)
case class OneDotperZipcodeintheU_S_Lite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.OneDotperZipcodeintheU_S_Lite)
case class OneDotperAirportintheU_S_OverlayedonGeoshapeLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.OneDotperAirportintheU_S_OverlayedonGeoshapeLite)
case class Rules_linesegmentsConnectingSEAtoeveryAirportReachableviaDirectFlightsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Rules_linesegmentsConnectingSEAtoeveryAirportReachableviaDirectFlightsLite)
case class ThreeChoroplethsRepresentingDisjointDatafromtheSameTableLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ThreeChoroplethsRepresentingDisjointDatafromtheSameTableLite)
case class U_S_StateCapitalsOverlayedonaMapofU_S_Lite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.U_S_StateCapitalsOverlayedonaMapofU_S_Lite)
case class LinebetweenAirportsintheU_S_Lite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LinebetweenAirportsintheU_S_Lite)
case class IncomeintheU_S_byStateFacetedoverIncomeBracketsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.IncomeintheU_S_byStateFacetedoverIncomeBracketsLite)
case class LondonTubeLinesLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.LondonTubeLinesLite)
case class ProjectionexplorerLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ProjectionexplorerLite)
case class BarChartwithHighlightingonHoverandSelectiononClickLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BarChartwithHighlightingonHoverandSelectiononClickLite)
case class InteractiveLegendLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.InteractiveLegendLite)
case class ScatterplotwithExternalLinksandTooltipsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ScatterplotwithExternalLinksandTooltipsLite)
case class RectangularBrushLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.RectangularBrushLite)
case class AreaChartwithRectangularBrushLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.AreaChartwithRectangularBrushLite)
case class PaintbrushHighlightLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.PaintbrushHighlightLite)
case class ScatterplotPanZoomLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ScatterplotPanZoomLite)
case class QueryWidgetsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.QueryWidgetsLite)
case class InteractiveAverageLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.InteractiveAverageLite)
case class MultiSeriesLineChartwithInteractiveHighlightLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.MultiSeriesLineChartwithInteractiveHighlightLite)
case class MultiSeriesLineChartwithLabelsLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.MultiSeriesLineChartwithLabelsLite)
case class MultiSeriesLineChartwithTooltipLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.MultiSeriesLineChartwithTooltipLite)
case class MultiSeriesLineChartwithTooltip0Lite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.MultiSeriesLineChartwithTooltip0Lite)
case class IsotypeGridLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.IsotypeGridLite)
case class BrushingScatterPlottoshowdataonatableLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BrushingScatterPlottoshowdataonatableLite)
case class SelectableHeatmapLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.SelectableHeatmapLite)
case class BarChartwithaMinimapLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.BarChartwithaMinimapLite)
case class InteractiveIndexChartLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.InteractiveIndexChartLite)
case class Focus_Context_SmoothHistogramZoomingLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Focus_Context_SmoothHistogramZoomingLite)
case class OverviewandDetailLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.OverviewandDetailLite)
case class CrossfilterLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.CrossfilterLite)
case class InteractiveScatterplotMatrix0Lite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.InteractiveScatterplotMatrix0Lite)
case class InteractiveDashboardwithCrossHighlightLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.InteractiveDashboardwithCrossHighlightLite)
case class SeattleWeatherExplorationLite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.SeattleWeatherExplorationLite)
case class ConnectionsamongMajorU_S_Airports_Lite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.ConnectionsamongMajorU_S_Airports_Lite)
case class Aninteractivescatterplotofglobalhealthstatisticsbycountryandyear_Lite (override val mods : JsonMod=List())(using PlotTarget) extends FromUrl(SpecUrl.Aninteractivescatterplotofglobalhealthstatisticsbycountryandyear_Lite)