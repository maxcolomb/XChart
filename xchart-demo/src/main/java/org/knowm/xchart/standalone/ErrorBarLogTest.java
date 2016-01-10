/**
 * Copyright 2015-2016 Knowm Inc. (http://knowm.org) and contributors.
 * Copyright 2011-2015 Xeiam LLC (http://xeiam.com) and contributors.
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
package org.knowm.xchart.standalone;

import java.awt.Color;

import org.knowm.xchart.Chart_XY;
import org.knowm.xchart.SeriesLineStyle;
import org.knowm.xchart.SeriesMarker;
import org.knowm.xchart.Series_XY;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.internal.style.colors.XChartSeriesColors;

/**
 * @author timmolter
 */
public class ErrorBarLogTest {

  public static void main(String[] args) throws Exception {

    double[] xData = new double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 };

    // double[] yData1 = new double[] { 100, 100, 100, 10, 10, 10, 10 };
    double[] yData1 = new double[] { 100, 100, 100, 60, 10, 10, 10 };

    double[] yData2 = new double[] { 150, 120, 110, 112, 19, 12, 11 };

    double[] yData3 = new double[] { 50, 80, 90, 8, 1, 8, 9 };

    // double[] errdata = new double[] { 1, .699, .301, 2, 1, .699, 0.301 };
    double[] errdata = new double[] { 50, 20, 10, 52, 9, 2, 1 };

    Chart_XY mychart = new Chart_XY(1200, 800);

    mychart.getStyleManager().setYAxisLogarithmic(true); // set log or linear Y axis

    mychart.getStyleManager().setYAxisMin(.08);

    mychart.getStyleManager().setYAxisMax(1000);

    mychart.getStyleManager().setErrorBarsColor(Color.black);

    Series_XY series1 = mychart.addSeries("Error bar test data", xData, yData1, errdata);

    Series_XY series2 = mychart.addSeries("Y+error", xData, yData2);

    Series_XY series3 = mychart.addSeries("Y-error", xData, yData3);

    series1.setLineStyle(SeriesLineStyle.SOLID);

    series1.setMarker(SeriesMarker.DIAMOND);

    series1.setMarkerColor(Color.MAGENTA);

    series2.setLineStyle(SeriesLineStyle.DASH_DASH);

    series2.setMarker(SeriesMarker.NONE);

    series2.setLineColor(XChartSeriesColors.RED);

    series3.setLineStyle(SeriesLineStyle.DASH_DASH);

    series3.setMarker(SeriesMarker.NONE);

    series3.setLineColor(XChartSeriesColors.RED);

    new SwingWrapper(mychart).displayChart();

  }

}